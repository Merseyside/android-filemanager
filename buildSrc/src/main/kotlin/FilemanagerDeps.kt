object FilemanagerDeps {

    object Plugins {
        val androidApplication = GradlePlugin(id = "com.android.application")
        val androidLibrary = GradlePlugin(id = "com.android.library")
        val kotlinKapt = GradlePlugin(id = "kotlin-kapt")
        val kotlinAndroid = GradlePlugin(id = "kotlin-android")
        val kotlinSerialization = GradlePlugin(id = "kotlinx-serialization")
        val mavenPublish = GradlePlugin(id = "maven-publish")
    }

    object Libs {

        val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${FilemanagerVersions.Libs.kotlinStdLib}"
        val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${FilemanagerVersions.Libs.serialization}"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${FilemanagerVersions.Libs.coroutines}"
        val appCompat = "androidx.appcompat:appcompat:${FilemanagerVersions.Libs.appCompat}"
        val annotation = "androidx.annotation:annotation:${FilemanagerVersions.Libs.appCompat}"

        val zip4j = "net.lingala.zip4j:zip4j:${FilemanagerVersions.Libs.zip4j}"

        val utils = "com.github.Merseyside.mersey-android-library:utils:${FilemanagerVersions.Libs.utils}"
    }
}