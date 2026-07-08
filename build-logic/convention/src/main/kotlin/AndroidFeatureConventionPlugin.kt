import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import config.disableUnnecessaryAndroidTests
import config.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Convention plugin for feature modules.
 * Applies common library, compose, hilt, and serialization plugins,
 * configures the Hilt-aware test instrumentation runner,
 * and adds shared test dependencies so individual feature modules
 * don't have to repeat this boilerplate.
 *
 * Inspired by nowinandroid's AndroidFeatureImplConventionPlugin.
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("config.android.library")
                apply("config.android.library.compose")
                apply("config.android.hilt")
                // Equivalent to kotlin("plugin.serialization") in build scripts
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<LibraryExtension> {
                // Override the default runner set by configureKotlinAndroid
                // with the Hilt-aware ApplicationTestRunner
                defaultConfig {
                    testInstrumentationRunner =
                        "com.athena.android_testing.runner.ApplicationTestRunner"
                }

                testOptions {
                    unitTests {
                        isIncludeAndroidResources = true
                    }
                    animationsDisabled = true
                }

                @Suppress("UnstableApiUsage")
                packaging {
                    resources {
                        excludes += setOf("META-INF/DEPENDENCIES")
                    }
                }
            }

            // Disable androidTest for modules without an androidTest source set
            val androidComponents =
                extensions.getByType<LibraryAndroidComponentsExtension>()
            androidComponents.disableUnnecessaryAndroidTests(target)

            val libs = libs

            dependencies {
                add("implementation", libs.findLibrary("androidx-core-ktx").get())
                add("implementation", libs.findLibrary("androidx-lifecycle-runtime-ktx").get())
                add("implementation", libs.findLibrary("androidx-ui-graphics").get())

                add("testImplementation", project(":testing"))
                add("androidTestImplementation", project(":android-testing"))
                add("debugImplementation", libs.findLibrary("androidx-ui-test-manifest").get())
            }
        }
    }
}
