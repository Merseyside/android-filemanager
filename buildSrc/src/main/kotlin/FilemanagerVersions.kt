object FilemanagerVersions {
    object Common {
        const val appId = "com.merseyside.filemanager"
    }

    object Android {
        const val compileSdk = 28
        const val targetSdk = 29
        const val minSdk = 21

        const val version = "1.0.3"
        const val versionCode = 103
    }

    const val kotlin = "1.4.21"

    object Plugins {
        const val kotlin = FilemanagerVersions.kotlin
        const val serialization = FilemanagerVersions.kotlin
        const val androidExtensions = FilemanagerVersions.kotlin
    }

    object Libs {

        const val kotlinStdLib = kotlin
        const val coroutines = "1.3.7"
        const val serialization = "1.0.1"
        const val appCompat = "1.1.0"
        const val material = "1.2.0-alpha05"
        const val fragment = "1.2.4"
        const val constraintLayout = "1.1.3"
        const val lifecycle = "2.0.0"
        const val cardView = "1.0.0"
        const val recyclerView = "1.0.0"
        const val zip4j = "2.6.0"
        const val utils = "1.3.0"
    }
}