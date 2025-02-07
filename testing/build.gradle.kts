plugins {
    id("config.android.library")
}

android {
    namespace = "com.athena.testing"
}

dependencies {

    api(libs.junit)
    api(libs.courotines.test)
    api(libs.mockk)
    api(libs.turbine)
}