plugins {
    id("config.android.library")
    id("config.android.hilt")
    id("config.android.room")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.athena.data"
    compileSdk = 34

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlin.serialization)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":network"))
    implementation(project(":domain"))
    implementation(project(":utils"))
}