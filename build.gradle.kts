plugins {
    kotlin("js") version "1.5.31"
    id("maven-publish")
    id("io.codearte.nexus-staging") version "0.30.0"
    signing
}

group = "com.github.ojaynico"
version = "1.1.6"

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val pomUrl = "https://github.com/ojaynico/ojaynico-kotlin-react-native"
val pomScmUrl = "https://github.com/ojaynico/ojaynico-kotlin-react-native"
val pomIssueUrl = "https://github.com/ojaynico/ojaynico-kotlin-react-native/issues"
val pomDesc = "https://github.com/ojaynico/ojaynico-kotlin-react-native"

val githubRepo = "https://github.com/ojaynico"
val githubReadme = "README.md"

val pomLicenseName = "MIT"
val pomLicenseUrl = "https://opensource.org/licenses/mit-license.php"
val pomLicenseDist = "repo"

val pomDeveloperId = "ojaynico"
val pomDeveloperName = "Nicodemus Ojwee"
val pomDeveloperEmail = "ojaynico@gmail.com"

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    js(BOTH) {
        nodejs {}
        useCommonJs()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.247-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:1.0.1-pre.247-kotlin-1.5.31")
    implementation(npm("react", "17.0.2"))
    implementation(npm("react-native", "0.65.1"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

publishing {
    repositories {
        maven {
            credentials {
                val sonatypeUsername: String by project
                val sonatypePassword: String by project
                username = sonatypeUsername
                password = sonatypePassword
            }
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
        }
    }
    publications {
        create<MavenPublication>("ojaynico-kotlin-react-native") {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["kotlin"])

            artifact(sourcesJar.get())

            pom.withXml {
                asNode().apply {
                    appendNode("description", pomDesc)
                    appendNode("name", rootProject.name)
                    appendNode("url", pomUrl)
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", pomLicenseName)
                        appendNode("url", pomLicenseUrl)
                        appendNode("distribution", pomLicenseDist)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", pomDeveloperId)
                        appendNode("name", pomDeveloperName)
                        appendNode("email", pomDeveloperEmail)
                    }
                    appendNode("scm").apply {
                        appendNode("connection", "scm:git:$pomScmUrl.git")
                        appendNode("developerConnection", "scm:git:$pomScmUrl.git")
                        appendNode("url", pomScmUrl)
                    }
                }
            }
        }
    }
}

nexusStaging {
    packageGroup = project.group.toString()

    val sonatypeUsername: String by project
    val sonatypePassword: String by project
    username = sonatypeUsername
    password = sonatypePassword
}

signing {
    sign(tasks["sourcesJar"])
    sign(publishing.publications["ojaynico-kotlin-react-native"])
}
