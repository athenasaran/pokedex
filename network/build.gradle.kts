plugins {
    id("config.android.library")
    id("config.android.hilt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.athena.network"
    compileSdk = 34

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlin.serialization)
    implementation(libs.logging.interceptor)
    implementation(libs.coil)
    implementation(libs.serialization)
}