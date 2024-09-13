plugins {
    id("config.android.library")
    id("config.android.library.compose")
    id("config.android.hilt")
}

android {
    namespace = "com.athena.features"
    compileSdk = 34

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(project(":design-system"))
}