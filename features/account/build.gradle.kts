plugins {
    id("config.android.library")
    id("config.android.library.compose")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.athena.features.account"
    compileSdk = 34

    defaultConfig {
        testInstrumentationRunner = "com.athena.android_testing.runner.ApplicationTestRunner"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        animationsDisabled = true
    }

    packaging {
        resources {
            excludes += setOf("META-INF/DEPENDENCIES")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui.graphics)
}