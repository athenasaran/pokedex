plugins {
    id("config.android.feature")
}

android {
    namespace = "com.athena.features.details"
}

dependencies {
    implementation(libs.coil)

    implementation(project(":design-system"))
    implementation(project(":domain"))
    implementation(project(":features"))
}
