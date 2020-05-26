plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)

    dataBinding {
        isEnabled = true
    }

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)

        applicationId = Versions.Common.appId

        versionCode = Versions.Android.versionCode
        versionName = Versions.Android.version

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
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
    Deps.Libs.Android.kotlinStdLib,
    Deps.Libs.Android.appCompat,
    Deps.Libs.Android.material,
    Deps.Libs.Android.fragment,
    Deps.Libs.Android.recyclerView,
    Deps.Libs.Android.lifecycle,
    Deps.Libs.Android.constraintLayout
)

dependencies {
    androidLibs.forEach { lib -> implementation(lib) }

    compileOnly("javax.annotation:jsr250-api:1.0")
}