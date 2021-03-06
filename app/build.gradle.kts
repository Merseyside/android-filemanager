plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(FilemanagerVersions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(FilemanagerVersions.Android.minSdk)
        targetSdkVersion(FilemanagerVersions.Android.targetSdk)

        applicationId = FilemanagerVersions.Common.appId

        versionCode = FilemanagerVersions.Android.versionCode
        versionName = FilemanagerVersions.Android.version

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    buildFeatures {
        dataBinding = true
    }

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
    }

    sourceSets.getByName("main") {
        res.srcDir("src/main/res/")
        res.srcDir("src/main/res/layouts/fragment")
        res.srcDir("src/main/res/layouts/activity")
        res.srcDir("src/main/res/layouts/views")
    }
}

val androidLibs = listOf(
    FilemanagerDeps.Libs.kotlinStdLib,
    FilemanagerDeps.Libs.appCompat
)

dependencies {
    androidLibs.forEach { lib -> implementation(lib) }

    compileOnly("javax.annotation:jsr250-api:1.0")
}