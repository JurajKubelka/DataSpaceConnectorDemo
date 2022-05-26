allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        maven { 
            url = uri("https://maven.iais.fraunhofer.de/artifactory/eis-ids-public")
        }
    }
//    group = "org.polypoly.dataloft.demo"
}
