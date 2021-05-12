allprojects {
    repositories {
        google()
        mavenCentral()

        maven { url = uri("https://kotlin.bintray.com/kotlinx")}
        maven { url = uri("https://kotlin.bintray.com/kotlin")}

        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class).configure {
    group = "build"
    delete(rootProject.buildDir)
}