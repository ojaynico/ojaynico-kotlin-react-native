package ojaynico.kotlin.react.navigator

import csstype.HtmlAttributes
import kotlinext.js.getOwnPropertyNames
import kotlinx.browser.window
import ojaynico.kotlin.react.json
import ojaynico.kotlin.react.native.*
import ojaynico.kotlin.react.native.api.*
import ojaynico.kotlin.react.native.component.StyleSheet
import ojaynico.kotlin.react.native.component.View
import react.*
import kotlin.js.Json

external interface RouteProps : Props {
    var name: String
    var component: dynamic
    var pathVariables: String
}

val Route = FC<RouteProps> { }

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

/*external interface NavigatorState : State {
    var initialSceneName: String
    var stack: List<Json>
    var sceneConfig: Json
    var showSideMenu: Boolean
    var touchX: dynamic
    var browserHistory: List<String>
}*/

external interface NavigatorProps : Props {
    var sideMenu: FC<*>
    var menuPosition: String
    var disableMenuGesture: Boolean
}

fun getSceneNameFromUrl(): String {
    val href = window.location.href
    return href.substringAfter("/#/").substringBefore("/")
}

val Navigator = FC<NavigatorProps> { props ->

    var initialSceneName: String by useState<String>("")
    var stack: List<Json> by useState<List<Json>>(emptyList())
    var sceneConfig: Json by useState<Json>(json {  })
    var showSideMenu: Boolean by useState<Boolean>(false)
    var touchX: dynamic by useState<Any>("")
    var browserHistory: List<String> by useState<List<String>>(emptyList())
    var firstTimeRender = useRef(true)

    val onBrowserHashChange = {
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

    val _animatedValue = Animated.Value(0)

    val handlePop = {
        Animated.asDynamic().timing(_animatedValue, json {
            toValue = if (state.showSideMenu && props.menuPosition == "left") -screenWidth else screenWidth
            duration = 250
            useNativeDriver = true
        }).start {

            if (showSideMenu) {
                if (props.menuPosition == "left") {
                    _animatedValue.setValue(screenWidth)
                } else {
                    _animatedValue.setValue(-screenWidth)
                }

                showSideMenu = false
            } else {
                _animatedValue.setValue(0)
            }

            if (stack.size > 1) {
                stack = stack.slice(0 until stack.size - 1)

                if (Platform.OS == "web") {
                    browserHistory = browserHistory.slice(0 until browserHistory.size - 1)
                }

                if (Platform.OS == "web") {
                    window.history.back()
                }
            }
        }
    }

    val backAction = {
        if (stack.size == 1 && !showSideMenu) {
            BackHandler.exitApp()
        } else {
            handlePop()
        }

        true
    }

    val getSceneProps: dynamic = { sceneName: String, pathVariables: String ->
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

        urlProps
    }

    useEffect(dependencies = emptyArray()) {

        firstTimeRender.current = false

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

        if (Platform.OS == "web") {
            window.onhashchange = { hashChangeEvent ->
                onBrowserHashChange()
            }
        }

        BackHandler.addEventListener(
            "hardwareBackPress",
            backAction()
        )
    }

    useEffect(dependencies = emptyArray()) {
        return@useEffect BackHandler.removeEventListener(
            "hardwareBackPress",
            backAction()
        )
    }

    val onSwipeLeft = {
        if (showSideMenu) {
            handlePop()

            showSideMenu = !showSideMenu
        }
    }

    val onSwipeRight = {
        if (showSideMenu) {
            handlePop()

            showSideMenu = !showSideMenu
        }
    }

    val changeUrl = { urlata: String, sceneName: String ->
        if (sceneName != "krnMenu") {
            if (Platform.OS == "web") {
                if (initialSceneName == sceneName) {
                    if (urlata.isNotEmpty())
                        window.history.pushState("", "", "/#${HtmlAttributes.data}")
                    else
                        window.history.pushState("", "", "/#/")
                } else {
                    if (urlata.isNotEmpty())
                        window.history.pushState("", "", "/#/$sceneName${HtmlAttributes.data}")
                    else
                        window.history.pushState("", "", "/#/$sceneName")
                }
            }
        }
        /*val path = if (state.initialSceneName == sceneName) window.location.protocol + "://" + window.location.host + "/#/"
        else
            window.location.protocol + "://" + window.location.host + "/#/" + sceneName + "/"

        val filterParam = window.location.href.substring(path.length - 1)
        return filterParam.split("/")*/
    }

    useEffect(dependencies = arrayOf(stack)) {
        if (!firstTimeRender.current!!) {
            if (stack.last()["key"].toString() == "krnMenu") {
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
        }
    }

    val handlePush = { sceneName: String, childProps: dynamic ->
        showSideMenu = sceneName == "krnMenu"

        if (childProps != undefined && childProps != "") {
            var propsParams = ""
            val props_tmp = childProps.unsafeCast<JSON>()
            val childPropsNames = props_tmp.getOwnPropertyNames()

            for (propName in childPropsNames) {
                propsParams += "/" + childProps[propName]
            }

            changeUrl(propsParams, sceneName)
        }

        sceneConfig[sceneName].unsafeCast<Json>()["props"] = childProps

        if (Platform.OS == "web") {
            browserHistory = browserHistory + listOf(sceneName)
        }

        stack = if (stack.last()["key"].toString() == "krnMenu") {
                stack.slice(0 until stack.size - 1) + listOf(sceneConfig[sceneName].unsafeCast<Json>())
            } else {
                stack + listOf(
                    sceneConfig[sceneName].unsafeCast<Json>()
                )
            }
    }



    val handleShowMenu = {
        handlePush("krnMenu") {}
    }

    View {
        style = json {
            asDynamic().flex = 1
            flexDirection = "row"
        }
        asDynamic().onTouchStart = { e: dynamic ->
            if (props.disableMenuGesture == undefined || !props.disableMenuGesture) {
                val pageX = e.nativeEvent.pageX
                touchX = pageX
            }
        }
        asDynamic().onTouchEnd = { e: dynamic ->
            if (props.disableMenuGesture == undefined || !props.disableMenuGesture) {
                val positionX = e.nativeEvent.pageX
                val range = screenWidth / 6

                if (positionX - touchX > range) {
                    onSwipeRight()
                } else if (touchX - positionX > range) {
                    onSwipeLeft()
                }
            }
        }

        if (!stack.isNullOrEmpty()) {
            stack.forEachIndexed { index, json ->
                val sceneStyles = StyleSheet.compose(
                    json {
                        asDynamic().flex = 1
                    },
                    StyleSheet.asDynamic().absoluteFillObject
                )

                if (index == stack.size - 1 && index > 0) {
                    sceneStyles.push(json {
                        transform = arrayOf(
                            json {
                                translateX = _animatedValue
                            }
                        )
                    })
                }

                // Fragments
                AnimatedView {
                    style = sceneStyles
                    asDynamic().key = json["key"].toString()

                    /*json.asDynamic().component.unsafeCast<FC<Props>> {
                        asDynamic().navigator = object : NavigatorFunctions {
                            override var pop = handlePop
                            override val push = handlePush
                            override var showMenu = handleShowMenu
                        }

                        if (json["props"] != undefined) {
                            val childProps = json["props"].unsafeCast<JSON>()
                            val childPropsNames = childProps.getOwnPropertyNames()
                            for (propName in childPropsNames) {
                                asDynamic()[propName] = window.asDynamic().decodeURI(json["props"].asDynamic()[propName])
                            }
                        }

                    }*/

                    /*child(json.asDynamic().component.unsafeCast<FC<Props>>()) {
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
                    }*/
                }
            }
        }

    }
}
