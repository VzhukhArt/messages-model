plugins {
    id("java-library")
    `maven-publish`
}

group = "com.dm.net.vzukh"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val jacksonVersion: String by project
val githubUsername: String by project
val githubPassword: String by project

dependencies {
    implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonVersion"))
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.core:jackson-annotations")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("com.fasterxml.jackson.core:jackson-databind")
}

java {
    withSourcesJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"]) // Публикует jar
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_REPOSITORY") ?: "VzhukhArt/messages-model"}")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: githubUsername
                password = System.getenv("GITHUB_TOKEN") ?: githubPassword
            }
        }
    }
}
