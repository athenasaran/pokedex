plugins {
    id("config.android.feature")
}

android {
    namespace = "com.athena.features.login"
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)

    implementation(project(":design-system"))
    implementation(project(":domain"))
    implementation(project(":features"))
}
