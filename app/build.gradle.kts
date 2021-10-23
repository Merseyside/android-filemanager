plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinSerialization)
}

android {
    compileSdkVersion(Versions.Application.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Application.minSdk)
        targetSdkVersion(Versions.Application.targetSdk)

        applicationId = Versions.Application.applicationId

        versionCode = Versions.Application.versionCode
        versionName = Versions.Application.version

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    buildFeatures {
        dataBinding = true
    }

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    sourceSets.getByName("main") {
        res.srcDir("src/main/res/")
        res.srcDir("src/main/res/layouts/fragment")
        res.srcDir("src/main/res/layouts/activity")
        res.srcDir("src/main/res/layouts/views")
    }
}

val android = listOf(
    androidLibs.appCompat
)

dependencies {
    android.forEach { lib -> implementation(lib) }
}