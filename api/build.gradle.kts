plugins {
    kotlin("jvm")
}

subprojects {
    if (!path.startsWith(":api:jigsaw")) {
        apply(plugin = "kotlin")
        apply(plugin = "jacoco")

        if (path != ":api:core") {
            dependencies {
                api(project(":api:core"))
            }
        }
    }
}

dependencies {
    subprojects.forEach {
        if (!it.path.startsWith(":api:jigsaw")) {
            this.api(project(it.path))
        }
    }
}
