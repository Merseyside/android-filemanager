plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinSerialization)
    id(Plugins.mavenPublish)
}

group = Versions.Application.groupId
version = Versions.Application.version

android {
    compileSdkVersion(Versions.Application.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Application.minSdk)
        targetSdkVersion(Versions.Application.targetSdk)
        versionCode = Versions.Application.versionCode
        versionName = Versions.Application.version
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
    common.serialization,
    androidLibs.zip4j,
    androidLibs.merseyLib.utils
)

dependencies {
    android.forEach { lib -> implementation(lib) }
}

afterEvaluate {
    publishing.publications {
        create<MavenPublication>("release") {
            groupId = group.toString()
            artifactId = project.name
            version = rootProject.version.toString()
            from(components["release"])
        }
    }

    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}