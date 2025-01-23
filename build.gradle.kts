plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("kapt") version "2.1.0"
}

group = "kyungkoo.io.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.dagger:dagger:2.55")
    kapt("com.google.dagger:dagger-compiler:2.55")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}