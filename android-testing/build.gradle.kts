plugins {
    id("config.android.library")
    id("config.android.hilt")
}

android {
    namespace = "com.athena.android_testing"
}

dependencies {

    api(libs.androidx.test.runner)
    api(libs.androidx.junit)
    api(libs.androidx.test.rules)
    api(libs.junit.compose.ui.test)
    api(libs.hilt.test)
    api(libs.mockk.android)
}