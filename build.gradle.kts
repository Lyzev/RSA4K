import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("maven-publish")
    id("org.jetbrains.dokka") version "1.6.10"
}

group = "me.lyzev.rsa"
version = "1.2"

repositories {
    mavenCentral()
}

tasks.getByName<DokkaTask>("dokkaHtml") {
    outputDirectory.set(buildDir.resolve("dokkaHtmlOutput"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.Lyzev"
            artifactId = "RSA4K"
            version = "1.2"

            from(components["java"])
        }
    }
}

apply(plugin = "maven-publish")

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
    }
}

apply(plugin = "com.github.johnrengelman.shadow")