plugins {
    id("config.android.application")
    id("config.android.application.compose")
    id("config.android.hilt")
    alias(libs.plugins.googleServices)
    kotlin("android")
}

android {
    namespace = "com.athena.pokedex"

    defaultConfig {
        applicationId = "com.athena.pokedex"
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
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)

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
    implementation(project(":data"))
    implementation(project(":design-system"))
    implementation(project(":domain"))
    implementation(project(":features"))
    implementation(project(":features:account"))
    implementation(project(":features:details"))
    implementation(project(":features:favorite"))
    implementation(project(":features:pokedex"))
    implementation(project(":features:regions"))
    debugImplementation(libs.androidx.ui.test.manifest)
}