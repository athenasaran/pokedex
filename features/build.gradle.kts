plugins {
    id("config.android.library")
    id("config.android.library.compose")
    id("config.android.hilt")
    id("config.android.room")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.athena.features"
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
    implementation(libs.serialization)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlin.serialization)
    implementation(libs.logging.interceptor)
    implementation(libs.coil)

    implementation(project(":design-system"))
    implementation(project(":network"))
    implementation(project(":domain"))

    testImplementation(project(":testing"))
    androidTestImplementation(project(":android-testing"))
    debugImplementation(libs.androidx.ui.test.manifest)
}