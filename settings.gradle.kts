enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    repositories {
        jcenter()
        google()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin") }
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
        maven { url = uri("https://jetbrains.bintray.com/kotlin-native-dependencies") }
    }

    resolutionStrategy.eachPlugin {
        // part of plugins defined in Deps.Plugins, part in buildSrc/build.gradle.kts
        val module = FilemanagerDeps.plugins[requested.id.id] ?: return@eachPlugin

        useModule(module)
    }
}

include(":app")
include(":filemanager")

rootProject.name="android-filemanager"