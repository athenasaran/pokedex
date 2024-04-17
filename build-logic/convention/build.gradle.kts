plugins {
    `kotlin-dsl`
}

group = "br.com.config.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.build.logic.android.gradlePlugin)
    compileOnly(libs.build.logic.kotlin.gradlePlugin)
}

gradlePlugin {

    plugins {

        register("androidLibrary") {
            id = "config.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}