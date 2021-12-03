plugins {
    kotlin("jvm") version "1.6.0"
    application
}

group = "me.tahlers"
version = "1.0-SNAPSHOT"

val kotestVersion = "5.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.vavr:vavr:0.10.4")
    implementation("io.vavr:vavr-kotlin:0.10.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}