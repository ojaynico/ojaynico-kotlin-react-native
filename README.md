# ojaynico-kotlin-react-native
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ojaynico/ojaynico-kotlin-react-native/badge.svg)](https://search.maven.org/artifact/com.github.ojaynico/ojaynico-kotlin-react-native/1.1.5/pom)
[![Kotlin](https://img.shields.io/badge/kotlin-1.5.30-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![npm version](https://img.shields.io/npm/v/react.svg?style=flat)](https://www.npmjs.com/package/react)
[![npm version](https://img.shields.io/npm/v/react-native?color=brightgreen&label=npm%20package)](https://www.npmjs.com/package/react-native)
[![Kotlin JS IR supported](https://img.shields.io/badge/Kotlin%2FJS-IR%20supported-yellow)](https://kotl.in/jsirsupported)

Kotlin Wrappers for React Native Components and APIs

Available components: All react native components are available in this wrapper. Check them out using the URL below:

https://reactnative.dev/docs/components-and-apis

Available APIs: All react native APIs are available in this wrapper. Check them out using the URL below:

https://reactnative.dev/docs/accessibilityinfo

## `How to use the wrapper?`

Use the cli tool below to generate a new Kotlin React Native application.

https://github.com/ojaynico/create-ojaynico-krn

Proceed to the next step after generating the project.

In your react native application shared module (a kotlin gradle project), update your gradle file to include the following in the respective blocks.

```kotlin
repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("com.github.ojaynico:ojaynico-kotlin-react-native:1.1.5")
}
```

### `Example of code snippet for a react native app using the above wrapper`

```kotlin
import ojaynico.kotlin.react.*
import ojaynico.kotlin.react.native.AppRegistry
import react.*

val styles = StyleSheet.create(object {
    val body = object {
            val backgroundColor = "#FFF"
    }
    val text = object {
            val fontSize = 24
            val fontWeight = "600"
            val color = "#000"
    }
}

class App : RComponent<Props, State>() {
    override fun RBuilder.render() {
        scrollView {
            attrs.contentInsetAdjustmentBehavior = "automatic"
            
            view {
                attrs.style = styles.body

                text("Welcome to Kotlin React Native") {
                    style = styles.text
                }
            }
        }
    }
}

fun main() {
    // For class components
    AppRegistry.registerComponent("MyApp") { App::class.js }
    // For functional components (Assume App is the functional component)
    // AppRegistry.registerComponent("MyApp") { App }
}
```

**NOTE:** In the main function, MyApp should be the same as the name of the app directory

**A fully set up and working example can be found in the repository below.**

https://github.com/ojaynico/KotlinReactNativeApp
