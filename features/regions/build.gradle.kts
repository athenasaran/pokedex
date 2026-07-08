plugins {
    id("config.android.feature")
}

android {
    namespace = "com.athena.features.regions"
}

dependencies {
    implementation(libs.coil)

    implementation(project(":design-system"))
    implementation(project(":domain"))
    implementation(project(":features"))
}
