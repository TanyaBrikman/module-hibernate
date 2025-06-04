import org.gradle.internal.declarativedsl.analysis.DefaultDataClass.Empty.properties

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.25"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(kotlin("test"))
    implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework:spring-context:6.2.7")
}


tasks.test {
    useJUnitPlatform()
}

