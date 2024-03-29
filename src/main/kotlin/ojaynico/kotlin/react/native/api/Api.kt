@file:JsModule("react-native")
@file:Suppress("unused")

package ojaynico.kotlin.react.native.api

import ojaynico.kotlin.react.ComponentProvider
import ojaynico.kotlin.react.native.component.*
import react.Component
import react.FC
import react.Props
import react.State
import kotlin.js.Promise

// Alert Component
external class Alert: Component<Props, State> {
    override fun render(): dynamic = definedExternally

    class Buttons(text: String, onPress: () -> Unit, style: String = definedExternally)

    companion object {
        fun alert(title: String,
                  message: String,
                  buttons: Array<Buttons> = definedExternally,
                  options : dynamic = definedExternally
        )
    }
}

external val AnimatedView : FC<ViewProps>

external class Animated : Component<Props, State> {

    class View : Component<ViewProps, State> {
        override fun render(): dynamic = definedExternally
    }

    class Text : Component<TextProps, State> {
        override fun render(): dynamic = definedExternally
    }

    class Image : Component<ImageProps, State> {
        override fun render(): dynamic = definedExternally
    }

    class ScrollView : Component<ScrollViewProps, State> {
        override fun render(): dynamic = definedExternally
    }

    class FlatList : Component<FlatListProps, State> {
        override fun render(): dynamic = definedExternally
    }

    class SectionList : Component<SectionListProps, State> {
        override fun render(): dynamic = definedExternally
    }

    class Value(value: dynamic) {
        fun setValue(value: Number)
        fun setOffset(offset: Number)
        fun flattenOffset()
        fun extractOffset()
        fun addListener(callback: (dynamic) -> Unit)
        fun removeListener(id: String)
        fun removeAllListeners()
        fun stopAnimation(callback: (dynamic) -> Unit)
        fun resetAnimation(callback: (dynamic) -> Unit)
        fun interpolate(config: dynamic)
        fun animate(animations: dynamic, callback: (dynamic) -> Unit)
        fun stopTracking()
        fun track(tracking: dynamic)
    }

    class ValueXY {
        fun setValue(value: Number)
        fun setOffset(offset: Number)
        fun flattenOffset()
        fun extractOffset()
        fun addListener(callback: (dynamic) -> Unit)
        fun removeListener(id: String)
        fun removeAllListeners()
        fun stopAnimation(callback: (dynamic) -> Unit)
        fun resetAnimation(callback: (dynamic) -> Unit)
        fun getLayout()
        fun getTranslateTransform()
    }

    companion object {
        fun decay(value: dynamic, config: dynamic)
        fun timing(value: dynamic, config: dynamic)
        fun spring(value: dynamic, config: dynamic)
        fun add(a: dynamic, b: dynamic)
        fun subtract(a: dynamic, b: dynamic)
        fun divide(a: dynamic, b: dynamic)
        fun multiply(a: dynamic, b: dynamic)
        fun modulo(a: dynamic, modulus: dynamic)
        fun diffClamp(a: dynamic, min: dynamic, mac: dynamic)
        fun delay(time: dynamic)
        fun sequence(animations: dynamic)
        fun parallel(animations: dynamic, config: dynamic)
        fun stagger(time: dynamic, animations: dynamic)
        fun loop(animation: dynamic, config: dynamic)
        fun event(argMapping: dynamic, config: dynamic)
        fun forkEvent(event: dynamic, listener: dynamic)
        fun unforkEvent(event: dynamic, listener: dynamic)
        fun start(callback: (dynamic) -> Unit)
        fun stop()
        fun reset()
    }

    override fun render(): dynamic = definedExternally
}

external object Appearance {
    fun getColorScheme(): dynamic
    fun addChangeListener(listener: dynamic)
    fun removeChangeListener(listener: dynamic)
}

external object AppRegistry {
    fun registerComponent(appKey: String, getComponentFunc: ComponentProvider): String
    fun setWrapperComponentProvider(componentProvider: () -> JsClass<dynamic>)
    fun enableArchitectureIndicator(enabled: Boolean)
    fun registerConfig(config: dynamic)
    fun registerComponent(appKey: String, getComponentFunc: ComponentProvider, section: Boolean)
    fun registerRunnable(appKey: String, run: () -> Unit)
    fun registerSection(appKey: String, componentProvider: ComponentProvider)
    fun getAppKeys()
    fun getSectionKeys()
    fun getSections()
    fun getRunnable(appKey: String)
    fun getRegistry()
    fun setComponentProviderInstrumentationHook(hook: (componentProvider: ComponentProvider, scopedPerformanceLogger: dynamic) -> Unit)
    fun runApplication(appKey: String, appParameters: dynamic)
    fun unmountApplicationComponentAtRootTag(rootTag: Number)
    fun registerHeadlessTask(taskKey: String, taskProvider: dynamic)
    fun registerCancellableHeadlessTask(taskKey: String, taskProvider: dynamic, taskCancelProvider: dynamic)
    fun startHeadlessTask(taskId: Number, taskKey: String, data: dynamic)
    fun cancelHeadlessTask(taskId: Number, taskKey: String)
}

external class AppState {
    companion object {
        val currentState: dynamic
        fun addEventListener(type: dynamic, handler: dynamic)
        fun removeEventListener(type: dynamic, handler: dynamic)
    }
}

external class DevSettings {
    companion object {
        fun addMenuItem(title: String, handler: () -> Unit)
        fun reload()
    }
}

external class Dimensions {
    companion object {
        fun addEventListener(type: dynamic, handler: dynamic)
        fun get(dim: dynamic): dynamic
        fun removeEventListener(type: dynamic, handler: dynamic)
        fun set(dims: dynamic)
    }
}

external class Easing {
    companion object {
        fun step0(n: dynamic): dynamic
        fun step1(n: dynamic): dynamic
        fun linear(t: dynamic)
        fun ease(t: dynamic)
        fun quad(t: dynamic)
        fun cubic(t: dynamic)
        fun poly(n: dynamic)
        fun sin(t: dynamic)
        fun circle(t: dynamic)
        fun exp(t: dynamic)
        fun elastic(bounciness: dynamic)
        fun back(s: dynamic)
        fun bounce(t: dynamic)
        fun bezier(x1: dynamic, y1: dynamic, x2: dynamic, y2: dynamic)
        fun `in`()
        fun out()
        fun inOut()
    }
}

external object InteractionManager {
    fun runAfterInteractions(task: dynamic): dynamic
    fun createInteractionHandle()
    fun clearInteractionHandle(handle: dynamic)
    fun setDeadline(deadline: dynamic)
}

external object Keyboard{
    fun addListener(eventName: dynamic, callback: () -> Unit): dynamic
    fun removeListener(eventName: dynamic, callback: () -> Unit)
    fun removeAllListeners(eventName: String)
    fun dismiss()
    fun scheduleLayoutAnimation(event: dynamic)
}

external object LayoutAnimation {
    fun configureNext(config: dynamic, onAnimationDidEnd: () -> Unit)
    fun create(duration: dynamic, type: dynamic, creationProp: dynamic): dynamic

    object Types {
        val spring: dynamic
        val linear: dynamic
        val easeInEaseOut: dynamic
        val easeIn: dynamic
        val easeOut: dynamic
        val keyboard: dynamic
    }

    object Properties {
        val opacity: dynamic
        val scaleX: dynamic
        val scaleY: dynamic
        val scaleXY: dynamic
    }

    object Presets {
        val easeInEaseOut: dynamic
        val linear: dynamic
        val spring: dynamic
    }
}

external class Linking {
    companion object {
        suspend fun addEventListener(type: dynamic, handler: dynamic)
        suspend fun removeEventListener(type: dynamic, handler: dynamic)
        suspend fun openURL(url: dynamic)
        suspend fun canOpenURL(url: dynamic): dynamic
        suspend fun openSettings()
        suspend fun getInitialURL(): dynamic
        suspend fun sendIntent(action: String, extras: dynamic)
    }
}

external object PanResponder {
    fun create(config: dynamic)
}

external class PixelRatio {
    companion object {
        fun get(): dynamic
        fun getFontScale(): Number
        fun getPixelSizeForLayoutSize(layoutSize: Number): Number
        fun roundToNearestPixel(layoutSize: Number): Number
    }
}

external fun PlatformColor(vararg colors: dynamic): dynamic

external class Share {
    companion object {
        suspend fun share(content: dynamic, options: dynamic): dynamic
        val sharedAction: dynamic
        val dismissedAction: dynamic
    }
}

external object Systrace {
    fun installReactHook(useFiber: dynamic)
    fun setEnabled(enabled: dynamic)
    fun isEnabled(): dynamic
    fun beginEvent(profileName: dynamic, args: dynamic)
    fun endEvent()
    fun beginAsyncEvent(profileName: dynamic)
    fun endAsyncEvent(profileName: dynamic, cookie: dynamic)
    fun counterEvent(profileName: dynamic, value: dynamic)
}

external object Vibration {
    fun vibrate()
    fun vibrate(pattern: dynamic, repeat: dynamic)
    fun cancel()
}

external object BackHandler {
    fun addEventListener(eventName: dynamic, handler: dynamic)
    fun exitApp()
    fun removeEventListener(eventName: dynamic, handler: dynamic)
}

external class PermissionsAndroid {
    companion object {
        suspend fun check(permission: String): dynamic
        suspend fun request(permission: String, rationale: dynamic): dynamic
        fun requestMultiple(permissions: Array<dynamic>): dynamic
    }
}

external object ToastAndroid {
    val SHORT: dynamic
    val LONG: dynamic
    val TOP: dynamic
    val BOTTOM: dynamic
    val CENTER: dynamic

    fun show(message: dynamic, duration: dynamic)
    fun showWithGravity(message: dynamic, duration: dynamic, gravity: dynamic)
    fun showWithGravityAndOffset(message: dynamic, duration: dynamic, gravity: dynamic, xOffset: dynamic, yOffset: dynamic)
}

external object ActionSheetIOS {
    fun showActionSheetWithOptions(options: dynamic, callback: (index: dynamic) -> Unit)
    fun showShareActionSheetWithOptions(options: dynamic, failureCallback: (error: dynamic) -> Unit, successCallback: (status: Boolean, method: String) -> Unit)
}

external fun DynamicColorIOS(arg: dynamic): dynamic

external object Settings {
    fun clearWatch(watchId: Number)
    fun get(key: String): dynamic
    fun set(settings: dynamic)
    fun watchKeys(keys: dynamic, callback: () -> Unit): Number
}

external var Platform: dynamic = definedExternally

external object AccessibilityInfo {
    fun isBoldTextEnabled(): Promise<Boolean>
    fun isGrayscaleEnabled(): Promise<Boolean>
    fun isInvertColorsEnabled(): Promise<Boolean>
    fun isReduceMotionEnabled(): Promise<Boolean>
    fun isReduceTransparencyEnabled(): Promise<Boolean>
    fun isScreenReaderEnabled(): Promise<Boolean>
    fun setAccessibilityFocus(reactTag: Number)
    fun sendAccessibilityEvent_unstable(handle: dynamic, eventType: dynamic)
    fun announceForAccessibility(announcement: String)
    fun getRecommendedTimeoutMillis(originalTimeout: Number): Promise<Number>
    fun addEventListener(eventName: String, handler: (args: dynamic) -> Unit): dynamic
    fun removeEventListener(eventName: String, handler: (args: dynamic) -> Unit)
}

external object Image {
    fun getSize(uri: String, success: () -> Unit, failure: () -> Unit): dynamic
    fun getSizeWithHeaders(uri: String, headers: dynamic, success: () -> Unit, failure: () -> Unit): dynamic
    fun prefetch(uri: String): dynamic
    fun abortPrefetch(requestId: Number): dynamic
    fun queryCache(vararg urls: String): dynamic
    fun resolveAssetSource(source: dynamic): dynamic
}

external object TextInput {
    fun focus()
    fun blur()
    fun clear()
    fun isFocused(): dynamic
}

external object FlatList {
    fun scrollToEnd(params: dynamic)
    fun scrollToIndex(params: dynamic)
    fun scrollToItem(params: dynamic)
    fun scrollToOffset(params: dynamic)
    fun recordInteraction()
    fun flashScrollIndicators()
    fun getNativeScrollRef()
    fun getScrollResponder()
    fun getScrollableNode()
}

external object ScrollView {
    fun flashScrollIndicators()
    fun scrollTo(vararg options: dynamic)
    fun scrollToEnd(vararg options: dynamic)
    fun scrollWithoutAnimationTo(y: dynamic, x: dynamic)
}

external object SectionList {
    fun scrollToLocation(params: dynamic)
    fun recordInteraction()
    fun flashScrollIndicators()
}

external object StatusBar {
    fun popStackEntry(entry: dynamic): dynamic
    fun pushStackEntry(entry: dynamic): dynamic
    fun replaceStackEntry(entry: dynamic, props: dynamic): dynamic
    fun setBackgroundColor(color: String, animated: Boolean)
    fun setBarStyle(style: dynamic, animated: Boolean)
    fun setHidden(hidden: Boolean, animation: dynamic)
    fun setNetworkActivityIndicatorVisible(visible: Boolean)
    fun setTranslucent(translucent: Boolean)
}

external object TouchableOpacity {
    fun setOpacityTo(value: Number, duration: Number)
}

external object VirtualizedList {
    fun scrollToEnd(params: dynamic)
    fun scrollToIndex(params: dynamic)
    fun scrollToItem(params: dynamic)
    fun scrollToOffset(params: dynamic)
    fun recordInteraction()
    fun flashScrollIndicators()
    fun getScrollRef()
    fun getScrollResponder()
    fun getScrollableNode()
    fun setNativeProps(params: dynamic)
    fun getChildContext() : dynamic
    fun hasMore(): Boolean
}

external object DrawerLayoutAndroid {
    fun closeDrawer()
    fun openDrawer()
}

external object TouchableNativeFeedback {
    fun SelectableBackground(rippleRadius: Number)
    fun SelectableBackgroundBorderless(rippleRadius: Number)
    fun Ripple(color: String, borderless: Boolean, rippleRadius: Number)
    fun canUseNativeForeground()
}
