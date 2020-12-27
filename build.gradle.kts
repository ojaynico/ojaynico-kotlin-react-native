plugins {
    kotlin("js") version "1.4.21"
    id("maven-publish")
    id("com.jfrog.bintray") version "1.8.4"
}

group = "ojaynico.kotlin.react.native"
version = "1.0.7"

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

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { url = uri("https://dl.bintray.com/ojaynico/ojaynico-kotlin-react-native") }
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    mavenLocal()
}

kotlin {
    js(BOTH) {
        nodejs {}
        useCommonJs()
    }
}

dependencies {
    implementation("org.jetbrains:kotlin-react:17.0.0-pre.133-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-extensions:1.0.1-pre.120-kotlin-1.4.10")
    implementation(npm("react", "17.0.0"))
    implementation(npm("react-native", "0.63.4"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

publishing {
    publications {
        create<MavenPublication>("ojaynico-kotlin-react-native") {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["kotlin"])

            artifact(sourcesJar)

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
                    }
                    appendNode("scm").apply {
                        appendNode("url", pomScmUrl)
                    }
                }
            }
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayKey").toString()
    publish = true

    setPublications("ojaynico-kotlin-react-native")

    pkg.apply {
        repo = "ojaynico-kotlin-react-native"
        name = artifactName
        githubRepo = githubRepo
        vcsUrl = pomScmUrl
        description = "Kotlin wrapper for react native components and APIs"
        setLabels("kotlin", "react", "react-native")
        setLicenses("MIT")
        desc = description
        websiteUrl = pomUrl
        issueTrackerUrl = pomIssueUrl
        githubReleaseNotesFile = githubReadme

        version.apply {
            name = artifactVersion
            desc = pomDesc
            released = "2020-12-27"
            vcsTag = artifactVersion
        }
    }
}
