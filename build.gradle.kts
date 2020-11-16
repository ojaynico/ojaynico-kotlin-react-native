plugins {
    kotlin("multiplatform") version "1.4.10"
    `maven-publish`
}

group = "ojaynico.kotlin.react.native"
version = "1.0"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
    jcenter()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js {
        nodejs()
        useCommonJs()
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains:kotlin-react:16.13.1-pre.120-kotlin-1.4.10")
                implementation("org.jetbrains:kotlin-extensions:1.0.1-pre.120-kotlin-1.4.10")
                implementation(npm("react", "16.13.1"))
                implementation(npm("react-native", "0.63.3", generateExternals=true))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}
