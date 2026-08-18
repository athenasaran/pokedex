plugins {
    id("config.android.feature")
}

android {
    namespace = "com.athena.features.pokedex"
}

dependencies {
    implementation(libs.coil)

    implementation(project(":design-system"))
    implementation(project(":domain"))
    implementation(project(":features"))
    implementation(project(":navigation"))
}
