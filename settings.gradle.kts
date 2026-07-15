pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "pokedex"
include(":app")
include(":design-system")
include(":features")
include(":network")
include(":testing")
include(":data")
include(":domain")
include(":utils")
include(":android-testing")
include(":features:account")
include(":features:details")
include(":features:favorite")
include(":features:pokedex")
include(":features:regions")
include(":features:login")
