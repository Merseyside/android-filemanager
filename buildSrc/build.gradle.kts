/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"
}

repositories {
    jcenter()
    google()

    maven { url = uri("https://dl.bintray.com/icerockdev/plugins") }
}

val kotlin = "1.4.21"
val gradle = "4.1.1"
val maven = "2.1"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("com.android.tools.build:gradle:$gradle")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin")
    implementation("com.github.dcendents:android-maven-gradle-plugin:$maven")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
