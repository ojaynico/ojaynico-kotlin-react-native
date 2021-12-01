# ojaynico-kotlin-react-native
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ojaynico/ojaynico-kotlin-react-native/badge.svg)](https://search.maven.org/artifact/com.github.ojaynico/ojaynico-kotlin-react-native/1.1.7/pom)
[![Kotlin](https://img.shields.io/badge/kotlin-1.6.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
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
    implementation("com.github.ojaynico:ojaynico-kotlin-react-native:1.1.7")
}
```

### `Example of a react native app using the above wrapper`

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

    // Code below will work if you have added react native web dependency to your project. 
    // Visit how to set up react native web in your project for a detailed instruction.
    // An example project using react native web is in the link at the end of this document.
    if (Platform.OS == "web") {
        AppRegistry.runApplication("MyApp", json {
            rootTag = document.getElementById("root")
        })
    }
}
```

### `Example using Navigation`

```kotlin
import ojaynico.kotlin.react.*
import ojaynico.kotlin.react.native.AppRegistry
import ojaynico.kotlin.react.native.Platform
import kotlinx.browser.document
import react.*

val Menu = functionComponent<MenuProps> { props ->
    view {
        this.attrs.style = json {
            flex = 1
            backgroundColor = "white"
            marginRight = "90%"
        }

        button {
            title = "Screen Two"
            onPress = {
                // props being passed through a json object
                // NOTE: An interface with the props below have to be defined and used by ScreenTwo component
                props.navigator.push("ScreenTwo", json {
                    name = "Nicodemus Ojwee"
                    age = 25
                    school = "Namilyango College"
                })
            }
        }
        button {
            title = "Screen Three"
            onPress = {
                props.navigator.push("ScreenThree", json {  })
            }
        }

    }
}

val App = functionComponent<Props> {
    navigator {
        this.attrs {
            // Side Menu (from above) is passed as functional component prop
            // Using asDynamic() for now till the next update
            asDynamic().sideMenu = Menu
            asDynamic().menuPosition = "left"
        }
        route {
            this.attrs {
                name = "ScreenOne"
                component = ScreenOne
            }
        }
        // pathVariables has to be defined as below if you plan to pass props in react native web
        // pathVariables names are supposed to be similar and in the order in which you have defined your props interface in ScreenTwoProps
        route {
            this.attrs {
                name = "ScreenTwo"
                component = ScreenTwo
                pathVariables = "name/age/school"
            }
        }
        route {
            this.attrs {
                name = "ScreenThree"
                component = ScreenThree
            }
        }
    }
}

val ScreenOne = functionComponent<NavigationProps> { props ->
    view {
        this.attrs.style = json {
            backgroundColor = "#59C9A5"
            flex = 1
        }

        button {
            title = "Menu"
            onPress = {
                props.navigator.showMenu()
            }
        }

        button {
            title = "Screen Two"
            onPress = {
                // props being passed through a json object
                // NOTE: An interface with the props below have to be defined and used by ScreenTwo component
                props.navigator.push("ScreenTwo", json {
                    name = "Nicodemus Ojwee"
                    age = 25
                    school = "Namilyango College"
                })
            }
        }

        button {
            title = "Pop"
            onPress = {
                props.navigator.pop()
            }
        }
    }
}

// If using web, the props defined in the interface below have to be defined as pathVariables
// in the route {} function above in App component and they have to follow the order.
external interface ScreenTwoProps : NavigationProps {
    var name: String
    var age: Int
    var school: String
}

val ScreenTwo = functionComponent<ScreenTwoProps> { props ->
    view {
        this.attrs.style = json {
            backgroundColor = "#23395B"
            flex = 1
            alignItems = "center"
            justifyContent = "center"
        }

        button {
            title = "Screen Three"
            onPress = {
                props.navigator.push("ScreenThree", json {  })
            }
        }

        button {
            title = "Pop"
            onPress = {
                props.navigator.pop()
            }
        }

        text("Name is " + props.name) {
            this.attrs {
                style = json {
                    color = "white"
                }
            }
        }

        text("Age is " + props.age) {
            this.attrs {
                style = json {
                    color = "white"
                }
            }
        }

        text("School is " + props.school) {
            this.attrs {
                style = json {
                    color = "white"
                }
            }
        }
    }
}

val ScreenThree = functionComponent<NavigationProps> { props ->
    view {
        this.attrs.style = json {
            backgroundColor = "#B9E3C6"
            flex = 1
            alignItems = "center"
            justifyContent = "center"
        }

        button {
            title = "Pop"
            onPress = {
                props.navigator.pop()
            }
        }
    }
}

fun main() {
    AppRegistry.registerComponent("MyApp") { App }

    // Code below will work if you have added react native web dependency to your project. 
    // Visit how to set up react native web in your project for a detailed instruction.
    // An example project using react native web is in the link at the end of this document.
    if (Platform.OS == "web") {
        AppRegistry.runApplication("MyApp", json {
            rootTag = document.getElementById("root")
        })
    }
}

```

**NOTE:** In the main function, MyApp should be the same as the name of the app directory

**A fully set up and working example can be found in the repository below.**

https://github.com/ojaynico/KotlinReactNativeApp
