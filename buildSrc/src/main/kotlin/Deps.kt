object Deps {
    object Plugins {
        const val kotlinSerialization =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.Plugins.serialization}"
        const val androidExtensions =
            "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.Plugins.androidExtensions}"
    }

    object Libs {

        val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Libs.kotlinStdLib}"
        val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Libs.coroutines}"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Libs.coroutines}"
        val appCompat = "androidx.appcompat:appcompat:${Versions.Libs.appCompat}"
        val material = "com.google.android.material:material:${Versions.Libs.material}"
        val fragment = "androidx.fragment:fragment-ktx:${Versions.Libs.fragment}"
        val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Libs.recyclerView}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Libs.constraintLayout}"
        val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.Libs.lifecycle}"
        val cardView = "androidx.cardview:cardview:${Versions.Libs.cardView}"
        val annotation = "androidx.annotation:annotation:${Versions.Libs.appCompat}"

        val zip4j = "net.lingala.zip4j:zip4j:${Versions.Libs.zip4j}"

    }

    val plugins: Map<String, String> = mapOf(
        "kotlin-android-extensions" to Plugins.androidExtensions,
        "kotlinx-serialization" to Plugins.kotlinSerialization
    )
}