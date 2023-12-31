plugins {
    kotlin("jvm") version "1.8.0"
    id ("org.springframework.boot") version "3.1.0"
    id ("io.spring.dependency-management") version "1.1.0"
//    id ("org.junit.jupiter.api") version "5.8.1" -> Thanks to "spring.dependency-management"
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
}

group = "org.example.groundstreet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0") // Mapping Json Response to Data

//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}


// for JUnit Test (./gradlew test)
tasks.test {
    useJUnitPlatform()
}
