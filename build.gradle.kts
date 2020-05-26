allprojects {
    repositories {
        google()
        jcenter()

        maven { url = uri("https://kotlin.bintray.com/kotlinx")}
        maven { url = uri("https://kotlin.bintray.com/kotlin")}

    }
}

tasks.register("clean", Delete::class).configure {
    group = "build"
    delete(rootProject.buildDir)
}