plugins {
    // java
    `java-library`
    id("application")
}

val edcVersion: String by project
val edcGroup: String by project
val rsApi: String by project
val openTelemetryVersion: String by project

dependencies {
    api("${edcGroup}:spi:${edcVersion}")
    implementation("${edcGroup}:transfer:${edcVersion}")
    implementation("${edcGroup}:data-plane-transfer-client:${edcVersion}")
    implementation("${edcGroup}:data-plane-selector-client:${edcVersion}")
    implementation("${edcGroup}:data-plane-selector-core:${edcVersion}")
    implementation("${edcGroup}:data-plane-selector-store:${edcVersion}")
    implementation("${edcGroup}:data-plane-framework:${edcVersion}")
    implementation("io.opentelemetry:opentelemetry-extension-annotations:${openTelemetryVersion}")

    implementation("${edcGroup}:data-plane-spi:${edcVersion}")

    api("${edcGroup}:dataloading:${edcVersion}")

    implementation("jakarta.ws.rs:jakarta.ws.rs-api:${rsApi}")
}

sourceSets["main"].java.srcDir("src/main/java")
