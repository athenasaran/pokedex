plugins {
    id("config.android.application")
    id("config.android.application.compose")
    id("config.android.hilt")
    kotlin("android")
}

android {
    namespace = "br.com.pokedex"

    defaultConfig {
        applicationId = "br.com.pokedex"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.core.splashscreen)
    implementation(project(":design-system"))
    implementation(project(":features"))
    implementation(project(":domain"))
    implementation(project(":data"))
    debugImplementation(libs.androidx.ui.test.manifest)
}