object FilemanagerVersions {
    object Common {
        const val appId = "com.merseyside.filemanager"
    }

    object Android {
        const val compileSdk = 28
        const val targetSdk = 30
        const val minSdk = 21

        const val version = "1.0.4"
        const val versionCode = 104
    }

    const val kotlin = "1.4.31"

    object Plugins {
        const val kotlin = FilemanagerVersions.kotlin
        const val serialization = FilemanagerVersions.kotlin
    }

    object Libs {

        const val kotlinStdLib = kotlin
        const val coroutines = "1.4.3"
        const val serialization = "1.1.0"
        const val appCompat = "1.1.0"
        const val zip4j = "2.6.0"
        const val utils = "1.3.2"
    }
}