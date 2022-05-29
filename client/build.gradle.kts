plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

val edcVersion: String by project
val edcGroup: String by project
val thisGroup: String by project
val jupiterVersion: String by project
val rsApi: String by project

dependencies {
    implementation("${edcGroup}:core:${edcVersion}")

    implementation("${edcGroup}:observability-api:${edcVersion}")

    implementation("${edcGroup}:filesystem-configuration:${edcVersion}")
    implementation("${edcGroup}:iam-mock:${edcVersion}")

    implementation(project(":client-auth"))
    implementation("${edcGroup}:data-management-api:${edcVersion}")

    implementation("${edcGroup}:ids:${edcVersion}") {
        exclude("${edcGroup}","ids-token-validation")
    }
}

application {
    mainClass.set("${edcGroup}.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    exclude("**/pom.properties", "**/pom.xm")
    mergeServiceFiles()
    archiveFileName.set("client.jar")
}
