package config

import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Project

/**
 * Disable unnecessary Android instrumented tests for the [project] if there is no `androidTest` folder
 * or if the folder exists but contains no actual test source files.
 * Otherwise, these projects would be compiled, packaged, installed and ran only to end-up with:
 *
 * > Starting 0 tests on AVD
 *
 * Adapted from nowinandroid's disabling strategy.
 */
internal fun LibraryAndroidComponentsExtension.disableUnnecessaryAndroidTests(
    project: Project,
) = beforeVariants {
    val androidTestDir = project.projectDir.resolve("src/androidTest")
    val hasTests = androidTestDir.exists() &&
            androidTestDir.walkTopDown()
                .any { it.isFile && (it.extension == "kt" || it.extension == "java") }

    it.androidTest.enable = it.androidTest.enable && hasTests
}
