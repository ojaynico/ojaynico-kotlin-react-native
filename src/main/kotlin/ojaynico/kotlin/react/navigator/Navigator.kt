package ojaynico.kotlin.react.navigator

import kotlinext.js.getOwnPropertyNames
import ojaynico.kotlin.react.animatedView
import ojaynico.kotlin.react.json
import ojaynico.kotlin.react.native.Animated
import ojaynico.kotlin.react.native.BackHandler
import ojaynico.kotlin.react.native.Dimensions
import ojaynico.kotlin.react.native.StyleSheet
import ojaynico.kotlin.react.view
import react.*
import kotlin.js.Json


external interface RouteProps : Props {
    var name: String
    var component: dynamic
}

val Route = functionComponent<RouteProps> { }

fun buildSceneConfig(children: Array<Json>, sideMenu: FunctionComponent<*>): Json {
    val config = json { }

    children.forEach { child ->
        config[child.asDynamic().props.name] = json {
            key = child.asDynamic().props.name
            component = child.asDynamic().props.component
        }
    }


    if (sideMenu != undefined) {
        config["krnMenu"] = json {
            key = "krnMenu"
            component = sideMenu
        }
    }

    return config.unsafeCast<Json>()
}

external interface NavigatorFunctions {
    var pop: () -> Unit
    val push: (routeName: String, props: dynamic) -> Unit
    var showMenu: () -> Unit
}

external interface NavigationProps : Props {
    var navigator: NavigatorFunctions
}

val screenWidth = Dimensions.get("window").width

external interface NavigatorState : State {
    var stack: List<Json>
    var sceneConfig: Json
    var showSideMenu: Boolean
    var touchX: dynamic
}

external interface NavigatorProps : Props {
    var sideMenu: FunctionComponent<*>
    var menuPosition: String
    var disableMenuGesture: Boolean
}

class Navigator : RComponent<NavigatorProps, NavigatorState>() {

    var backAction = {
        if (state.stack.size == 1 && !state.showSideMenu) {
            BackHandler.exitApp()
        } else {
            handlePop()
        }

        true
    }

    override fun componentDidMount() {
        val initialSceneName: String = props.asDynamic().children[0].props.name
        setState {
            sceneConfig = buildSceneConfig(props.asDynamic().children, props.sideMenu)
            stack = listOf(sceneConfig[initialSceneName].unsafeCast<Json>())
            showSideMenu = false
        }
        BackHandler.addEventListener(
            "hardwareBackPress",
            this.backAction
        )
    }

    override fun componentWillUnmount() {
        BackHandler.removeEventListener(
            "hardwareBackPress",
            this.backAction
        )
    }

    private fun onSwipeLeft() {
        if (state.showSideMenu) {
            handlePop()

            setState {
                showSideMenu = !showSideMenu
            }
        }
    }

    private fun onSwipeRight() {
        if (state.showSideMenu) {
            handlePop()

            setState {
                showSideMenu = !showSideMenu
            }
        }
    }

    val _animatedValue = Animated.Value(0)

    val handlePush = { sceneName: String, childProps: dynamic ->
        setState {
            showSideMenu = sceneName == "krnMenu"
        }

        setState({ navigatorState ->
            state.sceneConfig[sceneName].unsafeCast<Json>()["props"] = childProps
            navigatorState.stack =
                if (state.stack.last()["key"].toString() == "krnMenu") {
                    state.stack.slice(0 until state.stack.size - 1) + listOf(state.sceneConfig[sceneName].unsafeCast<Json>())
                } else {
                    state.stack + listOf(
                        state.sceneConfig[sceneName].unsafeCast<Json>()
                    )
                }

            navigatorState
        }, {
            if (sceneName == "krnMenu") {
                if (props.menuPosition == "left") {
                    _animatedValue.setValue(-screenWidth)
                } else {
                    _animatedValue.setValue(screenWidth)
                }
            } else {
                _animatedValue.setValue(screenWidth)
            }

            Animated.asDynamic().timing(_animatedValue, json {
                toValue = 0
                duration = 250
                useNativeDriver = true
            }).start()
        })
    }

    val handlePop = {
        Animated.asDynamic().timing(_animatedValue, json {
            toValue = if (state.showSideMenu && props.menuPosition == "left") -screenWidth else screenWidth
            duration = 250
            useNativeDriver = true
        }).start {

            if (state.showSideMenu) {
                if (props.menuPosition == "left") {
                    _animatedValue.setValue(screenWidth)
                } else {
                    _animatedValue.setValue(-screenWidth)
                }

                setState {
                    showSideMenu = false
                }
            } else {
                _animatedValue.setValue(0)
            }

            if (state.stack.size > 1) {
                setState {
                    stack = stack.slice(0 until stack.size - 1)
                }
            }
        }
    }

    val handleShowMenu = {
        handlePush("krnMenu") {}
    }

    override fun RBuilder.render() {
        view {
            this.attrs {
                style = json {
                    flex = 1
                    flexDirection = "row"
                }
                asDynamic().onTouchStart = { e: dynamic ->
                    if (props.disableMenuGesture == undefined || !props.disableMenuGesture) {
                        val pageX = e.nativeEvent.pageX
                        setState {
                            touchX = pageX
                        }
                    }
                }
                asDynamic().onTouchEnd = { e: dynamic ->
                    if (props.disableMenuGesture == undefined || !props.disableMenuGesture) {
                        val positionX = e.nativeEvent.pageX
                        val range = screenWidth / 6

                        if (positionX - state.touchX > range) {
                            onSwipeRight()
                        } else if (state.touchX - positionX > range) {
                            onSwipeLeft()
                        }
                    }
                }
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

                    // Fragments
                    animatedView {
                        this.attrs.asDynamic().key = json["key"].toString()
                        this.attrs.style = sceneStyles
                        child(json.asDynamic().component.unsafeCast<FunctionComponent<Props>>()) {

                            if (json["props"] != undefined) {
                                val childProps = json["props"].unsafeCast<JSON>()
                                val childPropsNames = childProps.getOwnPropertyNames()
                                for (propName in childPropsNames) {
                                    this.attrs.asDynamic()[propName] = json["props"].asDynamic()[propName]
                                }
                            }

                            this.attrs {
                                asDynamic().navigator = object : NavigatorFunctions {
                                    override var pop = handlePop
                                    override val push = handlePush
                                    override var showMenu = handleShowMenu
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
