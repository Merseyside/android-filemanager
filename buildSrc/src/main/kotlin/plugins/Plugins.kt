/**
 * Configuration of all gradle build plugins
 */
object Plugins {
    const val updateDependencies = "plugins.update-dependencies"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val androidConvention = "android-convention"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroid = "kotlin-android"
    const val mavenPublish = "maven-publish"
    const val mavenPublishConfig = "maven-publish-config"
    const val signing = "signing"
    const val kotlinSerialization = "kotlinx-serialization"
}
