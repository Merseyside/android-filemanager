buildscript {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    `nexus-config`
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class).configure {
    group = "build"
    delete(rootProject.buildDir)
}