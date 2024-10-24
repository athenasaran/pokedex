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
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {

    plugins {

        register("androidLibrary") {
            id = "config.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "config.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidApplicationCompose") {
            id = "config.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "config.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "config.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "config.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}