package ojaynico.kotlin.react

import ojaynico.kotlin.react.native.*
import react.RBuilder
import react.RElementBuilder

fun RBuilder.view(handler: RElementBuilder<ViewProps>.() -> Unit) = child(View::class) {
    handler()
}

fun RBuilder.animatedView(handler: RElementBuilder<ViewProps>.() -> Unit) = child(Animated.View::class) {
    handler()
}

fun RBuilder.text(text: String, handler: RElementBuilder<TextProps>.() -> Unit) = child(Text::class) {
    this.childList.add(text)
    handler()
}

fun RBuilder.animatedText(text: String, handler: RElementBuilder<TextProps>.() -> Unit) = child(Animated.Text::class) {
    this.childList.add(text)
    handler()
}

fun RBuilder.button(handler: ButtonProps.() -> Unit) = child(Button::class) {
    attrs(handler)
}

fun RBuilder.image(handler: ImageProps.() -> Unit) = child(Image::class) {
    attrs(handler)
}

fun RBuilder.animatedImage(handler: ImageProps.() -> Unit) = child(Animated.Image::class) {
    attrs(handler)
}

fun RBuilder.imageBackground(handler: RElementBuilder<ImageBackgroundProps>.() -> Unit) = child(ImageBackground::class) {
    handler()
}

fun RBuilder.textInput(handler: TextInputProps.() -> Unit) = child(TextInput::class) {
    attrs(handler)
}

fun RBuilder.switch(handler: SwitchProps.() -> Unit) = child(Switch::class) {
    attrs(handler)
}

fun RBuilder.flatList(handler: FlatListProps.() -> Unit) = child(FlatList::class) {
    attrs(handler)
}

fun RBuilder.animatedFlatList(handler: FlatListProps.() -> Unit) = child(Animated.FlatList::class) {
    attrs(handler)
}

fun RBuilder.sectionList(handler: SectionListProps.() -> Unit) = child(SectionList::class) {
    attrs(handler)
}

fun RBuilder.animatedSectionList(handler: SectionListProps.() -> Unit) = child(Animated.SectionList::class) {
    attrs(handler)
}

fun RBuilder.scrollView(handler: RElementBuilder<ScrollViewProps>.() -> Unit) = child(ScrollView::class) {
    handler()
}

fun RBuilder.animatedScrollView(handler: RElementBuilder<ScrollViewProps>.() -> Unit) = child(Animated.ScrollView::class) {
    handler()
}

fun RBuilder.safeAreaView(handler: RElementBuilder<SafeAreaViewProps>.() -> Unit) = child(SafeAreaView::class) {
    handler()
}

fun RBuilder.activityIndicator(handler: ActivityIndicatorProps.() -> Unit) = child(ActivityIndicator::class) {
    attrs(handler)
}

fun RBuilder.keyboardAvoidingView(handler: KeyboardAvoidingViewProps.() -> Unit) = child(KeyboardAvoidingView::class) {
    attrs(handler)
}

fun RBuilder.modal(handler: ModalProps.() -> Unit) = child(Modal::class) {
    attrs(handler)
}

fun RBuilder.pressable(handler: RElementBuilder<PressableProps>.() -> Unit) = child(Pressable::class) {
    handler()
}

fun RBuilder.refreshControl(handler: RefreshControlProps.() -> Unit) = child(RefreshControl::class) {
    attrs(handler)
}

fun RBuilder.statusBar(handler: StatusBarProps.() -> Unit) = child(StatusBar::class) {
    attrs(handler)
}

fun RBuilder.touchableHighlight(handler: TouchableHighlightProps.() -> Unit) = child(TouchableHighlight::class) {
    attrs(handler)
}

fun RBuilder.touchableOpacity(handler: RElementBuilder<TouchableOpacityProps>.() -> Unit) = child(TouchableOpacity::class) {
    handler()
}

fun RBuilder.touchableWithoutFeedback(handler: TouchableWithoutFeedbackProps.() -> Unit) = child(TouchableWithoutFeedback::class) {
    attrs(handler)
}

fun RBuilder.virtualizedList(handler: VirtualizedListProps.() -> Unit) = child(VirtualizedList::class) {
    attrs(handler)
}

fun RBuilder.drawerLayoutAndroid(handler: DrawerLayoutAndroidProps.() -> Unit) = child(DrawerLayoutAndroid::class) {
    attrs(handler)
}

fun RBuilder.touchableNativeFeedback(handler: TouchableNativeFeedbackProps.() -> Unit) = child(TouchableNativeFeedback::class) {
    attrs(handler)
}

fun RBuilder.inputAccessoryView(handler: InputAccessoryViewProps.() -> Unit) = child(InputAccessoryView::class) {
    attrs(handler)
}
