plugins {
    id("config.android.feature")
}

android {
    namespace = "com.athena.features"
}

dependencies {
    implementation(libs.serialization)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlin.serialization)
    implementation(libs.logging.interceptor)
    implementation(libs.coil)

    implementation(project(":design-system"))
    implementation(project(":network"))
    implementation(project(":domain"))
}
