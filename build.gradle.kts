plugins {
    id("java")
    application
}

group = "dev.cheercode.connectfour"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("dev.cheercode.connectfour.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "dev.cheercode.connectfour.Main"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}