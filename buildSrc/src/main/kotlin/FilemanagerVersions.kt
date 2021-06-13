object FilemanagerVersions {
    object Common {
        const val groupId = "com.github.Merseyside"
        const val appId = "com.merseyside.filemanager"
    }

    object Android {
        const val compileSdk = 30
        const val targetSdk = 30
        const val minSdk = 21

        const val version = "1.0.6"
        const val versionCode = 106
    }

    const val kotlin = "1.5.0"

    object Plugins {
        const val kotlin = FilemanagerVersions.kotlin
        const val serialization = FilemanagerVersions.kotlin
    }

    object Libs {

        const val kotlinStdLib = kotlin
        const val coroutines = "1.5.0"
        const val serialization = "1.2.1"
        const val appCompat = "1.1.0"
        const val zip4j = "2.6.0"
        const val utils = "1.3.6"
    }
}