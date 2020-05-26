object Deps {
    object Plugins {
        const val kotlinSerialization =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.Plugins.serialization}"
        const val androidExtensions =
            "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.Plugins.androidExtensions}"
    }

    object Libs {
        object Android {
            val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Libs.Android.kotlinStdLib}"
            val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Libs.Android.coroutines}"
            val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Libs.Android.coroutines}"
            val appCompat = "androidx.appcompat:appcompat:${Versions.Libs.Android.appCompat}"
            val material = "com.google.android.material:material:${Versions.Libs.Android.material}"
            val fragment = "androidx.fragment:fragment-ktx:${Versions.Libs.Android.fragment}"
            val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Libs.Android.recyclerView}"
            val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Libs.Android.constraintLayout}"
            val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.Libs.Android.lifecycle}"
            val cardView = "androidx.cardview:cardview:${Versions.Libs.Android.cardView}"
            val annotation = "androidx.annotation:annotation:${Versions.Libs.Android.appCompat}"
        }
    }

    val plugins: Map<String, String> = mapOf(
        "kotlin-android-extensions" to Plugins.androidExtensions,
        "kotlinx-serialization" to Plugins.kotlinSerialization
    )
}