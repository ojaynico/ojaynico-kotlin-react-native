package ojaynico.kotlin.react.navigator

import kotlinext.js.getOwnPropertyNames
import kotlinx.browser.window
import ojaynico.kotlin.react.animatedView
import ojaynico.kotlin.react.json
import ojaynico.kotlin.react.native.*
import ojaynico.kotlin.react.view
import react.*
import kotlin.js.Json

external interface RouteProps : Props {
    var name: String
    var component: dynamic
    var pathVariables: String
}

val Route = fc<RouteProps> { }

fun buildSceneConfig(children: Array<Json>, sideMenu: FC<*>): Json {
    val config = json { }

    children.forEach { child ->
        config[child.asDynamic().props.name] = json {
            key = child.asDynamic().props.name
            component = child.asDynamic().props.component
            pathVariables = child.asDynamic().props.pathVariables
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
    var initialSceneName: String
    var stack: List<Json>
    var sceneConfig: Json
    var showSideMenu: Boolean
    var touchX: dynamic
    var browserHistory: List<String>
}

external interface NavigatorProps : Props {
    var sideMenu: FC<*>
    var menuPosition: String
    var disableMenuGesture: Boolean
}

class Navigator : RComponent<NavigatorProps, NavigatorState>() {

    override fun componentDidMount() {
        setState {

            if (Platform.OS == "web" && !window.location.href.contains("/#/")) {
                window.history.pushState("", "", "/#/")
            }

            initialSceneName = if (Platform.OS == "web" && getSceneNameFromUrl().isNotEmpty()) getSceneNameFromUrl() else props.asDynamic().children[0].props.name
            sceneConfig = buildSceneConfig(props.asDynamic().children, props.sideMenu)

            if (Platform.OS == "web") {
                browserHistory = listOf(initialSceneName)
                val pathVariables = sceneConfig[initialSceneName].unsafeCast<Json>()["pathVariables"]

                if (pathVariables != undefined) {
                    sceneConfig[initialSceneName].unsafeCast<Json>()["props"] = getSceneProps(initialSceneName,
                        pathVariables as String
                    )
                }
            }

            stack = listOf(sceneConfig[initialSceneName].unsafeCast<Json>())
            showSideMenu = false
        }

        if (Platform.OS == "web") {
            window.onhashchange = { hashChangeEvent ->
                onBrowserHashChange()
            }
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

    private fun onBrowserHashChange() {
        window.location.reload()
        /*setState {
            val sceneName: String = getSceneNameFromUrl().ifEmpty { props.asDynamic().children[0].props.name as String }

            val pathVariables = sceneConfig[sceneName].unsafeCast<Json>()["pathVariables"]

            if (state.browserHistory.last() == sceneName) {
                handlePop()
            } else {
                handlePush(sceneName, getSceneProps(sceneName,
                    pathVariables as String
                ))
            }
        }*/
    }

    val backAction = {
        if (state.stack.size == 1 && !state.showSideMenu) {
            BackHandler.exitApp()
        } else {
            handlePop()
        }

        true
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

    private fun changeUrl(data: String, sceneName: String) {
        if (sceneName == "krnMenu") {
            return
        }

        if (Platform.OS == "web") {
            if (state.initialSceneName == sceneName) {
                if (data.isNotEmpty())
                    window.history.pushState("", "", "/#$data")
                else
                    window.history.pushState("", "", "/#/")
            } else {
                if (data.isNotEmpty())
                    window.history.pushState("", "", "/#/$sceneName$data")
                else
                    window.history.pushState("", "", "/#/$sceneName")
            }
        }

        /*val path = if (state.initialSceneName == sceneName) window.location.protocol + "://" + window.location.host + "/#/"
        else
            window.location.protocol + "://" + window.location.host + "/#/" + sceneName + "/"

        val filterParam = window.location.href.substring(path.length - 1)
        return filterParam.split("/")*/
    }

    private fun getSceneNameFromUrl(): String {
        val href = window.location.href
        return href.substringAfter("/#/").substringBefore("/")
    }

    private fun getSceneProps(sceneName: String, pathVariables: String): dynamic {
        val path = if (sceneName.isEmpty()) window.location.protocol + "://" + window.location.host + "/#/"
        else
            window.location.protocol + "://" + window.location.host + "/#/" + sceneName + "/"

        val filterParam = window.location.href.substring(path.length - 1)
        val values = filterParam.split("/")
        val variables = pathVariables.split("/")
        val urlProps = json {  }

        variables.forEachIndexed { index, s ->
            urlProps[s] = values[index]
        }

        return urlProps
    }

    val _animatedValue = Animated.Value(0)

    val handlePush = { sceneName: String, childProps: dynamic ->
        setState {
            showSideMenu = sceneName == "krnMenu"
        }

        if (childProps != undefined && childProps != "") {
            var propsParams = ""
            val props = childProps.unsafeCast<JSON>()
            val childPropsNames = props.getOwnPropertyNames()

            for (propName in childPropsNames) {
                propsParams += "/" + childProps[propName]
            }

            changeUrl(propsParams, sceneName)
        }


        setState({ navigatorState ->
            state.sceneConfig[sceneName].unsafeCast<Json>()["props"] = childProps

            if (Platform.OS == "web") {
                navigatorState.browserHistory = state.browserHistory + listOf(sceneName)
            }

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

                    if (Platform.OS == "web") {
                        browserHistory = browserHistory.slice(0 until browserHistory.size - 1)
                    }
                }

                if (Platform.OS == "web") {
                    window.history.back()
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
                        child(json.asDynamic().component.unsafeCast<FC<Props>>()) {
                            if (json["props"] != undefined) {
                                val childProps = json["props"].unsafeCast<JSON>()
                                val childPropsNames = childProps.getOwnPropertyNames()
                                for (propName in childPropsNames) {
                                    this.attrs.asDynamic()[propName] = window.asDynamic().decodeURI(json["props"].asDynamic()[propName])
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
