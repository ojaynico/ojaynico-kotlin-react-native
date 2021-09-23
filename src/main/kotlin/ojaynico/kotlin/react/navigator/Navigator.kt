package ojaynico.kotlin.react.navigator

import ojaynico.kotlin.react.animatedView
import ojaynico.kotlin.react.json
import ojaynico.kotlin.react.native.Animated
import ojaynico.kotlin.react.native.Dimensions
import ojaynico.kotlin.react.native.StyleSheet
import ojaynico.kotlin.react.view
import react.*
import kotlin.js.Json

external interface RouteProps : Props {
    var name: String
    var component: dynamic
}

val Route = functionComponent<RouteProps> {  }

fun buildSceneConfig(children: Array<Json>): Json {
    val config = json {  }

    children.forEach { child ->
        config[child.asDynamic().props.name] = json {
            key = child.asDynamic().props.name
            component = child.asDynamic().props.component
        }
    }

    return config as Json
}

external interface NavigationProps : Props {
    var navigator: dynamic
}

val width = Dimensions.get("window").width

external interface NavigatorState : State {
    var stack: List<Json>
    var sceneConfig: Json
}

class Navigator : RComponent<Props, NavigatorState>() {

    override fun componentDidMount() {
        val initialSceneName: String = props.asDynamic().children[0].props.name
        setState {
            sceneConfig = buildSceneConfig(props.asDynamic().children)
            stack = listOf(sceneConfig[initialSceneName] as Json)
        }
    }

    val _animatedValue = Animated.Value(0)

    val handlePush = { sceneName: String ->
        setState({ navigatorState ->
            navigatorState.stack = state.stack + listOf(state.sceneConfig[sceneName] as Json)
            navigatorState
        }, {
            _animatedValue.setValue(width)

            Animated.asDynamic().timing(_animatedValue, json {
                toValue = 0
                duration = 250
                useNativeDriver = true
            }).start()
        })
    }

    val handlePop = {
        Animated.asDynamic().timing(_animatedValue, json {
            toValue = width
            duration = 250
            useNativeDriver = true
        }).start {
            _animatedValue.setValue(0)
            if (state.stack.size > 1) {
                setState {
                    stack = stack.slice(0 until stack.size - 1)
                }
            }
        }
    }

    override fun RBuilder.render() {
        view {
            this.attrs.style = json {
                flex = 1
                flexDirection = "row"
            }

            if (!state.stack.isNullOrEmpty()) {
                state.stack.forEachIndexed { index, json ->
                    val sceneStyles = StyleSheet.compose(
                        json {
                            flex = 1
                        },
                        StyleSheet.asDynamic().absoluteFillObject
                    )

                    if (index == state.stack.size - 1 && index > 0) {
                        sceneStyles.push(json {
                            transform = arrayOf(
                                json {
                                    translateX = _animatedValue
                                }
                            )
                        })
                    }

                    animatedView {
                        this.attrs.asDynamic().key = json["key"].toString()
                        this.attrs.style = sceneStyles
                        child(json.asDynamic().component as FunctionComponent<NavigationProps>) {
                            this.attrs {
                                navigator = json {
                                    push = handlePush
                                    pop = handlePop
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}


// Functional Navigator Rendering Twice
/*val Navigator = functionComponent<Props> { props ->
    val sceneConfig = buildSceneConfig(props.asDynamic().children)
    val initialSceneName: String = props.asDynamic().children[0].props.name
    val _animatedValue = Animated.Value(0)

    val (stack, setStack) = useState(listOf(sceneConfig[initialSceneName] as Json))

    useLayoutEffect(dependencies = arrayOf(stack)) {
        _animatedValue.setValue(width)

        Animated.asDynamic().timing(_animatedValue, json {
            toValue = 0
            duration = 250
            useNativeDriver = true
        }).start()
    }

    val handlePush = { sceneName: String ->
        setStack(stack + sceneConfig[sceneName] as Json)
    }

    val handlePop = {
        Animated.asDynamic().timing(_animatedValue, json {
            toValue = width
            duration = 250
            useNativeDriver = true
        }).start {
            _animatedValue.setValue(0)
            if (stack.size > 1) {
                setStack(stack.slice(0 until stack.size - 1))
            }
        }
    }

    view {
        this.attrs.style = json {
            flex = 1
            flexDirection = "row"
        }

        stack.forEachIndexed { index, json ->
                val sceneStyles = StyleSheet.compose(json {
                    flex = 1
                },
                    StyleSheet.asDynamic().absoluteFillObject)

                if (index == stack.size - 1 && index > 0) {
                    sceneStyles.push(json {
                        transform = arrayOf(
                            json {
                                translateX = _animatedValue
                            }
                        )
                    })
                }

                animatedView {
                    this.attrs.asDynamic().key = json["key"].toString()
                    this.attrs.style = sceneStyles
                    child(json.asDynamic().component as FunctionComponent<NavigationProps>) {
                        this.attrs {
                            navigator = json {
                                push = handlePush
                                pop = handlePop
                            }
                        }
                    }
                }
            }

    }

}*/
