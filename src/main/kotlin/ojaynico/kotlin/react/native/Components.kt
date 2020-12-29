@file:JsModule("react-native")
@file:Suppress("unused")

package ojaynico.kotlin.react.native

import ojaynico.kotlin.react.ImageStyle
import ojaynico.kotlin.react.TextStyle
import ojaynico.kotlin.react.ViewStyle
import react.*

// View Component
external interface ViewProps : RProps {
    var onStartShouldSetResponder: (dynamic) -> Boolean
    var accessible: Boolean
    var accessibilityLabel: String
    var accessibilityHint: String
    var accessibilityRole: String
    var accessibilityState: dynamic
    var accessibilityValue: dynamic
    var accessibilityActions: List<dynamic>
    var onAccessibilityAction: (dynamic) -> Unit
    var onAccessibilityTap: () -> Unit
    var onMagicTap: () -> Unit
    var onAccessibilityEscape: () -> Unit
    var accessibilityViewIsModal: Boolean
    var accessibilityElementsHidden: Boolean
    var accessibilityIgnoresInvertColors: Boolean
    var accessibilityLiveRegion: String
    var importantForAccessibility: String
    var hitSlop: dynamic
    var nativeID: String
    var onLayout: () -> dynamic
    var onMoveShouldSetResponder: () -> Boolean
    var onMoveShouldSetResponderCapture: () -> Boolean
    var onResponderGrant: () -> Unit
    var onResponderMove: () -> Unit
    var onResponderReject: () -> Unit
    var onResponderRelease: () -> Unit
    var onResponderTerminate: () -> Unit
    var onResponderTerminationRequest: () -> Unit
    var onStartShouldSetResponderCapture: () -> Boolean
    var pointerEvents: String
    var removeClippedSubviews: Boolean
    var style: dynamic
    var testID: String
    var collapsable: Boolean
    var needsOffscreenAlphaCompositing: Boolean
    var renderToHardwareTextureAndroid: Boolean
    var shouldRasterizeIOS: Boolean
    var nextFocusDown: Number
    var nextFocusForward: Number
    var nextFocusLeft: Number
    var nextFocusRight: Number
    var nextFocusUp: Number
    var focusable: Boolean
}

external class View : Component<ViewProps, RState> {
    override fun render(): dynamic = definedExternally
}

// Text Component
external interface TextProps : RProps {
    var accessibilityLabel: String
    var accessibilityHint: String
    var accessibilityRole: String
    var accessibilityState: dynamic
    var accessible: Boolean
    var adjustsFontSizeToFit: Boolean
    var allowFontScaling: Boolean
    var dataDetectorType: String
    var disabled: Boolean
    var ellipsizeMode: String
    var maxFontSizeMultiplier: Number
    var minimumFontScale: Number
    var nativeID: String
    var numberOfLines: Number
    var onLayout: () -> dynamic
    var onLongPress: () -> Unit
    var onMoveShouldSetResponder: () -> Boolean
    var onPress: () -> Unit
    var onResponderGrant: () -> Unit
    var onResponderMove: () -> Unit
    var onResponderRelease: () -> Unit
    var onResponderTerminate: () -> Unit
    var onResponderTerminationRequest: () -> Unit
    var onStartShouldSetResponderCapture: () -> Boolean
    var onTextLayout: () -> Boolean
    var pressRetentionOffset: dynamic
    var selectable: Boolean
    var selectionColor: dynamic
    var style: dynamic
    var suppressHighlighting: Boolean
    var testID: String
    var textBreakStrategy: String
}

external class Text : Component<TextProps, RState> {
    override fun render(): dynamic = definedExternally
}

// Button Component
external interface ButtonProps : RProps {
    var onPress: () -> Unit
    var title: String
    var accessibilityLabel: String
    var color: String
    var disabled: Boolean
    var testID: String
    var hasTVPreferredFocus: Boolean
    var nextFocusDown: Number
    var nextFocusForward: Number
    var nextFocusLeft: Number
    var nextFocusRight: Number
    var nextFocusUp: Number
    var touchSoundDisabled: Boolean
}

external class Button : Component<ButtonProps, RState> {
    override fun render(): dynamic = definedExternally
}

// Image Component
external interface ImageProps : RProps {
    var style: dynamic
    var accessible: Boolean
    var accessibilityLabel: String
    var blurRadius: Number
    var capInsets: dynamic
    var defaultSource: Number
    var fadeDuration: Number
    var loadingIndicatorSource: Array<dynamic>
    var onError: () -> Unit
    var onLayout: (dynamic, dynamic, dynamic, dynamic) -> Unit
    var onLoad: () -> Unit
    var onLoadEnd: () -> Unit
    var onLoadStart: (dynamic) -> dynamic
    var onPartialLoad: () -> Unit
    var onProgress: (dynamic, dynamic) -> Unit
    var progressiveRenderingEnabled: Boolean
    var resizeMethod: String
    var resizeMode: String
    var source: dynamic
    var testID: String
}

external class Image : Component<ImageProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun getSize(uri: String, success: () -> Unit, failure: () -> Unit): dynamic
        fun getSizeWithHeaders(uri: String, headers: dynamic, success: () -> Unit, failure: () -> Unit): dynamic
        fun prefetch(uri: String): dynamic
        fun abortPrefetch(requestId: Number): dynamic
        fun queryCache(vararg urls: String): dynamic
        fun resolveAssetSource(source: dynamic): dynamic
    }
}

external interface ImageBackgroundProps : ImageProps, RProps {
    var imageStyle: dynamic
    var imageRef: dynamic
    override var style: dynamic
    override var accessible: Boolean
    override var accessibilityLabel: String
    override var blurRadius: Number
    override var capInsets: dynamic
    override var defaultSource: Number
    override var fadeDuration: Number
    override var loadingIndicatorSource: Array<dynamic>
    override var onError: () -> Unit
    override var onLayout: (dynamic, dynamic, dynamic, dynamic) -> Unit
    override var onLoad: () -> Unit
    override var onLoadEnd: () -> Unit
    override var onLoadStart: (dynamic) -> dynamic
    override var onPartialLoad: () -> Unit
    override var onProgress: (dynamic, dynamic) -> Unit
    override var progressiveRenderingEnabled: Boolean
    override var resizeMethod: String
    override var resizeMode: String
    override var source: dynamic
    override var testID: String
}

external class ImageBackground : Component<ImageBackgroundProps, RState> {
    override fun render(): dynamic = definedExternally
}

// TextInput Component
external interface TextInputProps : RProps {
    var allowFontScaling: Boolean
    var autoCapitalize: String
    var autoCompleteType: String
    var autoCorrect: Boolean
    var autoFocus: Boolean
    var blurOnSubmit: Boolean
    var caretHidden: Boolean
    var clearButtonMode: String
    var clearTextOnFocus: Boolean
    var contextMenuHidden: Boolean
    var dataDetectorTypes: String
    var defaultValue: String
    var disableFullscreenUI: Boolean
    var editable: Boolean
    var enablesReturnKeyAutomatically: Boolean
    var importantForAutofill: String
    var inlineImageLeft: String
    var inlineImagePadding: Number
    var inputAccessoryViewID: String
    var keyboardAppearance: String
    var keyboardType: String
    var maxFontSizeMultiplier: Number
    var maxLength: Number
    var multiline: Boolean
    var numberOfLines: Number
    var onBlur: () -> Unit
    var onChange: () -> Unit
    var onChangeText: (String) -> Unit
    var onContentSizeChange: () -> Unit
    var onEndEditing: () -> Unit
    var onFocus: () -> Unit
    var onKeyPress: () -> Unit
    var onLayout: () -> Unit
    var onScroll: () -> Unit
    var onSelectionChange: () -> Unit
    var onSubmitEditing: () -> Unit
    var onTextInput: () -> Unit
    var placeholder: String
    var placeholderTextColor: String
    var returnKeyLabel: String
    var returnKeyType: String
    var rejectResponderTermination: Boolean
    var scrollEnabled: Boolean
    var secureTextEntry: Boolean
    var selection: JSON
    var selectionColor: String
    var selectTextOnFocus: Boolean
    var showSoftInputOnFocus: Boolean
    var spellCheck: Boolean
    var textAlign: String
    var textContentType: String
    var passwordRules: String
    var style: dynamic
    var textBreakStrategy: String
    var underlineColorAndroid: String
    var value: String
}

external class TextInput : Component<TextInputProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun focus()
        fun blur()
        fun clear()
        fun isFocused(): dynamic
    }
}

// Switch Component
external interface SwitchProps : RProps {
    var disabled: Boolean
    var ios_backgroundColor: String
    var onChange: () -> Unit
    var onValueChange: () -> Unit
    var thumbColor: String
    var trackColor: dynamic
    var value: Boolean
}

external class Switch : Component<SwitchProps, RState> {
    override fun render(): dynamic = definedExternally
}

// FlatList Component
external interface FlatListProps : RProps {
    var renderItem: (arguments: dynamic) -> dynamic
    var data: Array<dynamic>
    var itemSeparatorComponent: dynamic
    var listEmptyComponent: dynamic
    var listFooterComponent: dynamic
    var listFooterComponentStyle: dynamic
    var listHeaderComponent: dynamic
    var ListHeaderComponentStyle: dynamic
    var columnWrapperStyle: dynamic
    var extraData: dynamic
    var getItemLayout: (data: dynamic, index: Number) -> Unit
    var horizontal: Boolean
    var initialNumToRender: Number
    var initialScrollIndex: Number
    var inverted: Boolean
    var keyExtractor: (item: dynamic, index: Number) -> String
    var numColumns: Number
    var onEndReached: (info: dynamic) -> Unit
    var onEndReachedThreshold: Number
    var onRefresh: () -> Unit
    var onViewableItemsChanged: (info: dynamic) -> Unit
    var progressViewOffset: Number
    var refreshing: Boolean
    var removeClippedSubviews: Boolean
    var viewabilityConfig: dynamic
    var viewabilityConfigCallbackPairs: dynamic
}

external class FlatList : Component<FlatListProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
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
}

// ScrollView Component
external interface ScrollViewProps : RProps {
    var alwaysBounceHorizontal: Boolean
    var alwaysBounceVertical: Boolean
    var automaticallyAdjustContentInsets: Boolean
    var bounces: Boolean
    var bouncesZoom: Boolean
    var canCancelContentTouches: Boolean
    var centerContent: Boolean
    var contentContainerStyle: dynamic
    var contentInset: JSON
    var contentInsetAdjustmentBehavior: String
    var contentOffset: JSON
    var decelerationRate: String
    var directionalLockEnabled: Boolean
    var disableIntervalMomentum: Boolean
    var disableScrollViewPanResponder: Boolean
    var endFillColor: String
    var fadingEdgeLength: Int
    var horizontal: Boolean
    var indicatorStyle: String
    var invertStickyHeaders: Boolean
    var keyboardDismissMode: String
    var keyboardShouldPersistTaps: String
    var maintainVisibleContentPosition: JSON
    var maximumZoomScale: Int
    var minimumZoomScale: Int
    var nestedScrollEnabled: Boolean
    var onContentSizeChange: () -> Unit
    var onMomentumScrollBegin: () -> Unit
    var onMomentumScrollEnd: () -> Unit
    var onScroll: () -> Unit
    var onScrollBeginDrag: () -> Unit
    var onScrollEndDrag: () -> Unit
    var onScrollToTop: () -> Unit
    var overScrollMode: String
    var pagingEnabled: Boolean
    var persistentScrollbar: Boolean
    var pinchGestureEnabled: Boolean
    var refreshControl: dynamic
    var removeClippedSubviews: Boolean
    var scrollBarThumbImage: Int
    var scrollEnabled: Boolean
    var scrollEventThrottle: Int
    var scrollIndicatorInsets: JSON
    var scrollPerfTag: String
    var scrollToOverflowEnabled: Boolean
    var scrollsToTop: Boolean
    var showsHorizontalScrollIndicator: Boolean
    var showsVerticalScrollIndicator: Boolean
    var snapToAlignment: String
    var snapToEnd: Boolean
    var snapToInterval: Int
    var snapToOffsets: Array<Int>
    var snapToStart: Boolean
    var stickyHeaderIndices: Array<Int>
    var zoomScale: Int
}

external class ScrollView : Component<ScrollViewProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun flashScrollIndicators()
        fun scrollTo(vararg options: dynamic)
        fun scrollToEnd(vararg options: dynamic)
        fun scrollWithoutAnimationTo(y: dynamic, x: dynamic)
    }
}

// SafeAreaView Component
external interface SafeAreaViewProps : ViewProps {
    var emulateUnlessSupported: Boolean
}

external class SafeAreaView: Component<SafeAreaViewProps, RState> {
    override fun render(): dynamic = definedExternally
}

// SectionList Component
external interface SectionListProps : RProps {
    var emulateUnlessSupported: Boolean
    var renderItem: (item: dynamic, index: Int, separators: dynamic) -> Unit
    var section: Array<dynamic>
    var ItemSeparatorComponent: dynamic
    var ListEmptyComponent: dynamic
    var ListFooterComponent: dynamic
    var ListHeaderComponent: dynamic
    var columnWrapperStyle: dynamic
    var extraData: dynamic
    var getItemLayout: (data: dynamic, index: Int) -> Unit
    var horizontal: Boolean
    var initialNumToRender: Int
    var initialScrollIndex: Int
    var inverted: Boolean
    var keyExtractor: (item: dynamic, index: Int) -> String
    var numColumns: Int
    var onEndReached: (info: dynamic) -> Unit
    var onEndReachedThreshold: Int
    var onRefresh: () -> Unit
    var onViewableItemsChanged: (info: dynamic) -> Unit
    var refreshing: Boolean
    var removeClippedSubviews: Boolean
    var renderSectionHeader: (info: dynamic) -> dynamic
    var renderSectionFooter: (info: dynamic) -> dynamic
    var sectionSeparatorComponent: dynamic
    var stickySectionHeadersEnabled: Boolean
}

external class SectionList: Component<SectionListProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun scrollToLocation(params: dynamic)
        fun recordInteraction()
        fun flashScrollIndicators()
    }
}

// ActivityIndicator Component
external interface ActivityIndicatorProps : RProps {
    var animating: Boolean
    var color: String
    var hidesWhenStopped: Boolean
    var size: dynamic
}

external class ActivityIndicator: Component<ActivityIndicatorProps, RState> {
    override fun render(): dynamic = definedExternally
}

external class StyleSheet {
    var absoluteFill: dynamic = definedExternally
    var absoluteFillObject: dynamic = definedExternally
    var hairlineWidth: dynamic = definedExternally

    companion object {
        fun compose(style1: dynamic, style2: dynamic): dynamic
        fun create(obj: dynamic): dynamic
        fun flatten(style: Array<dynamic>): dynamic
        fun setStyleAttributePreprocessor(property: String, process: (propValue: dynamic) -> dynamic)
    }
}

external interface KeyboardAvoidingViewProps : ViewProps, RProps {
    var behavior: dynamic
    var contentContainerStyle: dynamic
    var enabled: Boolean
    override var onStartShouldSetResponder: (dynamic) -> Boolean
    override var accessible: Boolean
    override var accessibilityLabel: String
    override var accessibilityHint: String
    override var accessibilityRole: String
    override var accessibilityState: dynamic
    override var accessibilityValue: dynamic
    override var accessibilityActions: List<dynamic>
    override var onAccessibilityAction: (dynamic) -> Unit
    override var onAccessibilityTap: () -> Unit
    override var onMagicTap: () -> Unit
    override var onAccessibilityEscape: () -> Unit
    override var accessibilityViewIsModal: Boolean
    override var accessibilityElementsHidden: Boolean
    override var accessibilityIgnoresInvertColors: Boolean
    override var accessibilityLiveRegion: String
    override var importantForAccessibility: String
    override var hitSlop: dynamic
    override var nativeID: String
    override var onLayout: () -> dynamic
    override var onMoveShouldSetResponder: () -> Boolean
    override var onMoveShouldSetResponderCapture: () -> Boolean
    override var onResponderGrant: () -> Unit
    override var onResponderMove: () -> Unit
    override var onResponderReject: () -> Unit
    override var onResponderRelease: () -> Unit
    override var onResponderTerminate: () -> Unit
    override var onResponderTerminationRequest: () -> Unit
    override var onStartShouldSetResponderCapture: () -> Boolean
    override var pointerEvents: String
    override var removeClippedSubviews: Boolean
    override var style: dynamic
    override var testID: String
    override var collapsable: Boolean
    override var needsOffscreenAlphaCompositing: Boolean
    override var renderToHardwareTextureAndroid: Boolean
    override var shouldRasterizeIOS: Boolean
    override var nextFocusDown: Number
    override var nextFocusForward: Number
    override var nextFocusLeft: Number
    override var nextFocusRight: Number
    override var nextFocusUp: Number
    override var focusable: Boolean

}

external class KeyboardAvoidingView : Component<KeyboardAvoidingViewProps, RState> {
    override fun render(): dynamic = definedExternally
}

external interface ModalProps : RProps {
    var animationType: dynamic
    var hardwareAccelerated: Boolean
    var onDismiss: () -> Unit
    var onOrientationChange: () -> Unit
    var onRequestClose: () -> Unit
    var onShow: () -> Unit
    var presentationStyle: dynamic
    var statusBarTranslucent: Boolean
    var supportedOrientations: dynamic
    var transparent: Boolean
    var visible: Boolean
}

external class Modal : Component<ModalProps, RState> {
    override fun render(): dynamic = definedExternally
}

external interface PressableProps : RProps {
    var android_disableSound: Boolean
    var android_ripple: dynamic
    var children: dynamic
    var delayLongPress: Number
    var disabled: Boolean
    var hitSlop: dynamic
    var onLongPress: dynamic
    var onPress: dynamic
    var onPressIn: dynamic
    var onPressOut: dynamic
    var pressRetentionOffset: dynamic
    var style: dynamic
    var testOnly_pressed: Boolean
}

external class Pressable : Component<PressableProps, RState> {
    override fun render(): dynamic = definedExternally
}

external interface RefreshControlProps : RProps {
    var refreshing: Boolean
    var onRefresh: () -> Unit
    var colors: Array<dynamic>
    var enabled: Boolean
    var progressBackgroundColor: dynamic
    var progressViewOffset: Number
    var size: dynamic
    var tintColor: dynamic
    var title: String
    var titleColor: dynamic
}

external class RefreshControl : Component<RefreshControlProps, RState> {
    override fun render(): dynamic = definedExternally
}

external interface StatusBarProps : RProps {
    var animated: Boolean
    var backgroundColor: dynamic
    var barStyle: dynamic
    var hidden: Boolean
    var networkActivityIndicatorVisible: Boolean
    var showHideTransition: dynamic
    var translucent: Boolean
}

external class StatusBar : Component<StatusBarProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun popStackEntry(entry: dynamic): dynamic
        fun pushStackEntry(entry: dynamic): dynamic
        fun replaceStackEntry(entry: dynamic, props: dynamic): dynamic
        fun setBackgroundColor(color: String, animated: Boolean)
        fun setBarStyle(style: dynamic, animated: Boolean)
        fun setHidden(hidden: Boolean, animation: dynamic)
        fun setNetworkActivityIndicatorVisible(visible: Boolean)
        fun setTranslucent(translucent: Boolean)
    }
}

external interface TouchableHighlightProps : RProps {
    var activeOpacity: Number
    var onHideUnderlay: () -> Unit
    var onShowUnderlay: () -> Unit
    var style: dynamic
    var underlayColor: dynamic
    var hasTVPreferredFocus: Boolean
    var nextFocusDown: Boolean
    var nextFocusForward: Boolean
    var nextFocusLeft: Boolean
    var nextFocusRight: Boolean
    var nextFocusUp: Boolean
    var testOnly_pressed: Boolean
}

external class TouchableHighlight : Component<TouchableHighlightProps, RState> {
    override fun render(): dynamic = definedExternally

}

external interface TouchableOpacityProps : RProps {
    var style: dynamic
    var onPress: () -> Unit
    var activeOpacity: Number
    var tvParallaxProperties: dynamic
    var hasTVPreferredFocus: Boolean
    var nextFocusDown: Boolean
    var nextFocusForward: Boolean
    var nextFocusLeft: Boolean
    var nextFocusRight: Boolean
    var nextFocusUp: Boolean
}

external class TouchableOpacity : Component<TouchableOpacityProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun setOpacityTo(value: Number, duration: Number)
    }
}

external interface TouchableWithoutFeedbackProps : RProps {
    var accessibilityIgnoresInvertColors: Boolean
    var accessible: Boolean
    var accessibilityLabel: String
    var accessibilityHint: String
    var accessibilityRole: String
    var accessibilityState: dynamic
    var accessibilityActions: Array<dynamic>
    var onAccessibilityAction: () -> Unit
    var accessibilityValue: dynamic
    var delayLongPress: Number
    var delayPressIn: Number
    var delayPressOut: Number
    var disabled: Boolean
    var hitSlop: dynamic
    var onBlur: () -> Unit
    var onFocus: () -> Unit
    var onLayout: () -> Unit
    var onLongPress: () -> Unit
    var onPress: () -> Unit
    var onPressIn: () -> Unit
    var onPressOut: () -> Unit
    var pressRetentionOffset: dynamic
    var nativeID: String
    var testID: String
    var touchSoundDisabled: Boolean
}

external class TouchableWithoutFeedback : Component<TouchableWithoutFeedbackProps, RState> {
    override fun render(): dynamic = definedExternally
}

external interface VirtualizedListProps : RProps {
    var renderItem: (arguments: dynamic) -> dynamic
    var data: dynamic
    var getItem: (data: dynamic, index: Number) -> dynamic
    var getItemCount: (data: dynamic) -> Number
    var debug: Boolean
    var extraData: dynamic
    var getItemLayout: (data: dynamic, index: Number) -> dynamic
    var initialScrollIndex: Number
    var inverted: Boolean
    var CellRendererComponent: dynamic
    var ItemSeparatorComponent: dynamic
    var listKey: String
    var ListEmptyComponent: dynamic
    var ListItemComponent: dynamic
    var ListFooterComponent: dynamic
    var ListFooterComponentStyle: dynamic
    var ListHeaderComponent: dynamic
    var ListHeaderComponentStyle: dynamic
    var onRefresh: () -> Unit
    var onScrollToIndexFailed: (info: dynamic) -> Unit
    var onViewableItemsChanged: (info: dynamic) -> Unit
    var refreshing: Boolean
    var refreshControl: dynamic
    var removeClippedSubviews: Boolean
    var renderScrollComponent: (props: dynamic) -> dynamic
    var viewabilityConfig: dynamic
    var viewabilityConfigCallbackPairs: dynamic
    var horizontal: Boolean
    var initialNumToRender: Number
    var keyExtractor: (item: dynamic, index: Number) -> String
    var maxToRenderPerBatch: Number
    var onEndReached: (info: dynamic) -> Unit
    var onEndReachedThreshold: Number
    var updateCellsBatchingPeriod: Number
    var windowSize: Number
    var persistentScrollbar: Boolean
    var progressViewOffset: Number
}

external class VirtualizedList : Component<VirtualizedListProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
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
}

external interface DrawerLayoutAndroidProps : RProps {
    var drawerBackgroundColor:  dynamic
    var drawerLockMode: dynamic
    var drawerPosition: dynamic
    var drawerWidth: Number
    var keyboardDismissMode: dynamic
    var onDrawerClose: () -> Unit
    var onDrawerOpen: () -> Unit
    var onDrawerSlide: () -> Unit
    var onDrawerStateChanged: () -> Unit
    var renderNavigationView: () -> Unit
    var statusBarBackgroundColor: dynamic
}

external class DrawerLayoutAndroid : Component<DrawerLayoutAndroidProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun closeDrawer()
        fun openDrawer()
    }
}

external interface TouchableNativeFeedbackProps : RProps {
    var background: dynamic
    var useForeground: Boolean
    var hasTVPreferredFocus: Boolean
    var nextFocusDown: Boolean
    var nextFocusForward: Boolean
    var nextFocusLeft: Boolean
    var nextFocusRight: Boolean
    var nextFocusUp: Boolean
}

external class TouchableNativeFeedback : Component<TouchableNativeFeedbackProps, RState> {
    override fun render(): dynamic = definedExternally

    companion object {
        fun SelectableBackground(rippleRadius: Number)
        fun SelectableBackgroundBorderless(rippleRadius: Number)
        fun Ripple(color: String, borderless: Boolean, rippleRadius: Number)
        fun canUseNativeForeground()
    }
}

external interface InputAccessoryViewProps : RProps {
    var backgroundColor: dynamic
    var nativeID: String
    var style: dynamic
}

external class InputAccessoryView : Component<InputAccessoryViewProps, RState> {
    override fun render(): dynamic = definedExternally
}
