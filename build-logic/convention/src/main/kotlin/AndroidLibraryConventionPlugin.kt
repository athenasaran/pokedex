import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import config.configureKotlinAndroid
import config.disableUnnecessaryAndroidTests
import config.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("kotlin-android")
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
            }

            val androidComponents =
                extensions.getByType<LibraryAndroidComponentsExtension>()
            androidComponents.disableUnnecessaryAndroidTests(project)
        }
    }
}