import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.31"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
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

        info.events(TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}

application {
    // Define the main class for the application.
    mainClassName = "sample.AppKt"
}