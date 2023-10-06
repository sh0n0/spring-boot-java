import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.errorprone
import java.util.*

plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
    id("com.diffplug.spotless") version "6.22.0"
    id("net.ltgt.errorprone") version "3.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    errorprone("com.google.errorprone:error_prone_core:2.22.0")
    annotationProcessor("com.uber.nullaway:nullaway:0.10.14")
    testAnnotationProcessor("com.uber.nullaway:nullaway:0.10.14")
}

tasks.withType<JavaCompile> {
    options.errorprone {
        check("NullAway", CheckSeverity.ERROR)
        option("NullAway:AnnotatedPackages", "com.example")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat()
    }
}
