plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("com.github.dcendents.android-maven")
}


group = "com.github.Merseyside"
version = FilemanagerVersions.Android.version

android {
    compileSdkVersion(FilemanagerVersions.Android.compileSdk)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        minSdkVersion(FilemanagerVersions.Android.minSdk)
        targetSdkVersion(FilemanagerVersions.Android.targetSdk)
        versionCode = FilemanagerVersions.Android.versionCode
        versionName = FilemanagerVersions.Android.version
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
    FilemanagerDeps.Libs.zip4j
)

dependencies {
    androidLibs.forEach { lib -> implementation(lib) }

    compileOnly("javax.annotation:jsr250-api:1.0")
}
repositories {
    mavenCentral()
}