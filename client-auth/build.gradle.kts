plugins {
    `java-library`
}

val edcVersion: String by project
val edcGroup: String by project
val rsApi: String by project
val openTelemetryVersion: String by project

dependencies {
    implementation("${edcGroup}:auth-spi:${edcVersion}")
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:${rsApi}")
}

sourceSets["main"].java.srcDir("src/main/java")
