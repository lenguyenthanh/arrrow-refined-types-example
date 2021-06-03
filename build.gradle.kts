import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven ("https://oss.sonatype.org/content/repositories/snapshots/" )
    }
    dependencies {
        classpath ("io.arrow-kt:arrow-refined-types-gradle-plugin:1.5.0-SNAPSHOT")
    }
}

plugins {
    kotlin("jvm") version "1.5.0"
    kotlin("kapt") version "1.5.0"
    id("application")
    id("org.jmailen.kotlinter") version "3.4.0"
    id("io.kotest") version "0.3.8"
    kotlin("plugin.serialization") version "1.5.0"
//    id("com.github.jengelman.gradle.plugins:shadow") version "6.1.0"
}

apply(plugin = "io.arrow-kt.refined-types")

group = "se.thanh.ladder"
version = "0.1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
    mavenCentral()
    maven ("https://oss.sonatype.org/content/repositories/snapshots/" )
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    implementation(platform("io.arrow-kt:arrow-stack:0.13.2"))
    implementation("io.arrow-kt:arrow-core")
    implementation("io.arrow-kt:arrow-fx-coroutines")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "15"
    }
}