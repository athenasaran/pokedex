plugins {
    id("config.android.library")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.athena.navigation"
}

dependencies {
    implementation(libs.serialization)
}
