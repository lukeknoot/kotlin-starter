import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.31"
    id("org.jlleitschuh.gradle.ktlint") version "8.0.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging:1.6.24")
    implementation("org.slf4j:slf4j-api:1.7.25")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("ch.qos.logback:logback-core:1.2.3")
    implementation("com.pinterest:ktlint:0.32.0") {
        exclude("org.slf4j", "slf4j-nop")
    }

    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.FAILED)

        debug {
            events(*enumValues<TestLogEvent>())
            setExceptionFormat(TestExceptionFormat.FULL)
        }

        testLogging.showStandardStreams = true

        info.events(TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}

application {
    // Define the main class for the application.
    mainClassName = "template.AppKt"
}
