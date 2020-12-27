# ojaynico-kotlin-react-native

[ ![Download](https://api.bintray.com/packages/ojaynico/ojaynico-kotlin-react-native/ojaynico-kotlin-react-native/images/download.svg?version=1.0.6) ](https://bintray.com/ojaynico/ojaynico-kotlin-react-native/ojaynico-kotlin-react-native/1.0.6/link)

Kotlin Wrappers for React Native Components and APIs

Java Version : 14

Kotlin Version : 1.4.21

React Version : 17.0.0

React Native Version : 0.63.4

Available components: All react native components are available in this wrapper. Check them out using the URL below:

https://reactnative.dev/docs/components-and-apis

Available APIs: All react native APIs are available in this wrapper. Check them out using the URL below:

https://reactnative.dev/docs/accessibilityinfo

## `How to use the wrapper?`

In your react native application shared module (a kotlin gradle project), update your gradle file to include the following in the respective blocks.

```kotlin
repositories {
    maven { url = uri("https://dl.bintray.com/ojaynico/ojaynico-kotlin-react-native") }
    jcenter()
}

dependencies {
    implementation("ojaynico.kotlin.react.native:ojaynico-kotlin-react-native:1.0.7")
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

class App : RComponent<RProps, RState>() {
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
    AppRegistry.registerComponent("MyApp") { App::class.js }
}
```

**NOTE:** In the main function, MyApp should be the same as the name of the app directory

**A fully set up and working example can be found in the repository below.**

https://github.com/ojaynico/KotlinReactNativeApp
