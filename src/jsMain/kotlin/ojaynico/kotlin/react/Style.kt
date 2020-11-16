package ojaynico.kotlin.react

interface LayoutStyle {
    val alignContent: dynamic
    val alignItems: dynamic
    val alignSelf: dynamic
    val aspectRatio: Number?
    val backgroundColor: String?
    val borderBottomWidth: Number?
    val borderEndWidth: dynamic
    val borderLeftWidth: Number?
    val borderRightWidth: Number?
    val borderStartWidth: dynamic
    val borderTopWidth: Number?
    val borderWidth: Number?
    var borderColor: dynamic
    val bottom: dynamic
    val direction: dynamic
    val display: dynamic
    val end: dynamic
    val flex: Number?
    val flexBasis: dynamic
    val flexDirection: dynamic
    val flexGrow: Number?
    val flexShrink: Number?
    val flexWrap: dynamic
    val height: dynamic
    val justifyContent: dynamic
    val left: dynamic
    val margin: dynamic
    val marginBottom: dynamic
    val marginEnd: dynamic
    val marginHorizontal: dynamic
    val marginLeft: dynamic
    val marginRight: dynamic
    val marginStart: dynamic
    val marginTop: dynamic
    val marginVertical: dynamic
    val maxHeight: dynamic
    val maxWidth: dynamic
    val minHeight: dynamic
    val minWidth: dynamic
    val overflow: dynamic
    val padding: dynamic
    val paddingBottom: dynamic
    val paddingEnd: dynamic
    val paddingHorizontal: dynamic
    val paddingLeft: dynamic
    val paddingRight: dynamic
    val paddingStart: dynamic
    val paddingTop: dynamic
    val paddingVertical: dynamic
    val position: dynamic
    val right: dynamic
    val start: dynamic
    val top: dynamic
    val width: dynamic
    val zIndex: Number?
}

class LayoutStyleC(
    val alignContent: dynamic = undefined,
    val alignItems: dynamic = undefined,
    val alignSelf: dynamic = undefined,
    val aspectRatio: Number? = undefined,
    val borderBottomWidth: Number? = undefined,
    val borderEndWidth: dynamic = undefined,
    val borderLeftWidth: Number? = undefined,
    val borderRightWidth: Number? = undefined,
    val borderStartWidth: dynamic = undefined,
    val borderTopWidth: Number? = undefined,
    val borderWidth: Number? = undefined,
    var borderColor: dynamic = undefined,
    val bottom: dynamic = undefined,
    val direction: dynamic = undefined,
    val display: dynamic = undefined,
    val end: dynamic = undefined,
    val flex: Number? = undefined,
    val flexBasis: dynamic = undefined,
    val flexDirection: dynamic = undefined,
    val flexGrow: Number? = undefined,
    val flexShrink: Number? = undefined,
    val flexWrap: dynamic = undefined,
    val height: dynamic = undefined,
    val justifyContent: dynamic = undefined,
    val left: dynamic = undefined,
    val margin: dynamic = undefined,
    val marginBottom: dynamic = undefined,
    val marginEnd: dynamic = undefined,
    val marginHorizontal: dynamic = undefined,
    val marginLeft: dynamic = undefined,
    val marginRight: dynamic = undefined,
    val marginStart: dynamic = undefined,
    val marginTop: dynamic = undefined,
    val marginVertical: dynamic = undefined,
    val maxHeight: dynamic = undefined,
    val maxWidth: dynamic = undefined,
    val minHeight: dynamic = undefined,
    val minWidth: dynamic = undefined,
    val overflow: dynamic = undefined,
    val padding: dynamic = undefined,
    val paddingBottom: dynamic = undefined,
    val paddingEnd: dynamic = undefined,
    val paddingHorizontal: dynamic = undefined,
    val paddingLeft: dynamic = undefined,
    val paddingRight: dynamic = undefined,
    val paddingStart: dynamic = undefined,
    val paddingTop: dynamic = undefined,
    val paddingVertical: dynamic = undefined,
    val position: dynamic = undefined,
    val right: dynamic = undefined,
    val start: dynamic = undefined,
    val top: dynamic = undefined,
    val width: dynamic = undefined,
    val zIndex: Number? = undefined,
)

open class ViewStyle(
    val borderRightColor: String? = undefined,
    val backfaceVisibility: String? = undefined,
    val borderBottomColor: String? = undefined,
    val borderBottomEndRadius: Number? = undefined,
    val borderBottomLeftRadius: Number? = undefined,
    val borderBottomRightRadius: Number? = undefined,
    val borderBottomStartRadius: Number? = undefined,
    override val borderBottomWidth: Number? = undefined,
    override var borderColor: String? = undefined,
    val borderEndColor: String? = undefined,
    val borderLeftColor: String? = undefined,
    override val borderLeftWidth: Number? = undefined,
    val borderRadius: Number? = undefined,
    override val backgroundColor: String? = undefined,
    override val borderRightWidth: Number? = undefined,
    val borderStartColor: String? = undefined,
    val borderStyle: Number? = undefined,
    val borderTopColor: Number? = undefined,
    val borderTopEndRadius: Number? = undefined,
    val borderTopLeftRadius: Number? = undefined,
    val borderTopRightRadius: Number? = undefined,
    val borderTopStartRadius: Number? = undefined,
    override val borderTopWidth: Number? = undefined,
    override val borderWidth: Number? = undefined,
    val opacity: Number? = undefined,
    val elevation: Number? = undefined,
    override val alignItems: dynamic = undefined,

    override val alignSelf: dynamic = undefined,

    override val aspectRatio: Number? = undefined,

    override val borderEndWidth: dynamic = undefined,

    override val borderStartWidth: dynamic = undefined,

    override val bottom: dynamic = undefined,

    override val direction: dynamic = undefined,

    override val display: dynamic = undefined,

    override val end: dynamic = undefined,

    override val flex: Number? = undefined,

    override val flexBasis: dynamic = undefined,

    override val flexDirection: dynamic = undefined,

    override val flexGrow: Number? = undefined,

    override val flexShrink: Number? = undefined,

    override val flexWrap: dynamic = undefined,

    override val height: dynamic = undefined,

    override val justifyContent: dynamic = undefined,

    override val left: dynamic = undefined,

    override val margin: dynamic = undefined,

    override val marginBottom: dynamic = undefined,

    override val marginEnd: dynamic = undefined,

    override val marginHorizontal: dynamic = undefined,

    override val marginLeft: dynamic = undefined,

    override val marginRight: dynamic = undefined,

    override val marginStart: dynamic = undefined,

    override val marginTop: dynamic = undefined,

    override val marginVertical: dynamic = undefined,

    override val maxHeight: dynamic = undefined,

    override val maxWidth: dynamic = undefined,

    override val minHeight: dynamic = undefined,

    override val minWidth: dynamic = undefined,

    override val overflow: dynamic = undefined,

    override val padding: dynamic = undefined,

    override val paddingBottom: dynamic = undefined,

    override val paddingEnd: dynamic = undefined,

    override val paddingHorizontal: dynamic = undefined,

    override val paddingLeft: dynamic = undefined,

    override val paddingRight: dynamic = undefined,

    override val paddingStart: dynamic = undefined,

    override val paddingTop: dynamic = undefined,

    override val paddingVertical: dynamic = undefined,

    override val position: dynamic = undefined,

    override val right: dynamic = undefined,

    override val start: dynamic = undefined,

    override val top: dynamic = undefined,

    override val width: dynamic = undefined,

    override val zIndex: Number? = undefined,

    override val alignContent: dynamic = undefined
) : LayoutStyle

class TextStyle(
    val textShadowOffset: dynamic = undefined,
    val color: String? = undefined,
    val fontSize: Number? = undefined,
    val fontStyle: String? = undefined,
    val fontWeight: String? = undefined,
    val lineHeight: Number? = undefined,
    val textAlign: String? = undefined,
    val textDecorationLine: String? = undefined,
    val textShadowColor: String? = undefined,
    val fontFamily: String? = undefined,
    val textShadowRadius: Number? = undefined,
    val includeFontPadding: Boolean? = undefined,
    val textAlignVertical: String? = undefined,
    val fontVariant: dynamic = undefined,
    val letterSpacing: Number? = undefined,
    val textDecorationColor: String? = undefined,
    val textDecorationStyle: String? = undefined,
    val textTransform: String? = undefined,
    val writingDirection: String? = undefined,
    override val alignContent: dynamic = undefined,

    override val alignItems: dynamic = undefined,

    override val alignSelf: dynamic = undefined,

    override val aspectRatio: Number? = undefined,

    override val borderEndWidth: dynamic = undefined,

    override val borderStartWidth: dynamic = undefined,

    override val bottom: dynamic = undefined,

    override val direction: dynamic = undefined,

    override val display: dynamic = undefined,

    override val end: dynamic = undefined,

    override val flex: Number? = undefined,

    override val flexBasis: dynamic = undefined,

    override val flexDirection: dynamic = undefined,

    override val flexGrow: Number? = undefined,

    override val flexShrink: Number? = undefined,

    override val flexWrap: dynamic = undefined,

    override val height: dynamic = undefined,

    override val justifyContent: dynamic = undefined,

    override val left: dynamic = undefined,

    override val margin: dynamic = undefined,

    override val marginBottom: dynamic = undefined,

    override val marginEnd: dynamic = undefined,

    override val marginHorizontal: dynamic = undefined,

    override val marginLeft: dynamic = undefined,

    override val marginRight: dynamic = undefined,

    override val marginStart: dynamic = undefined,

    override val marginTop: dynamic = undefined,

    override val marginVertical: dynamic = undefined,

    override val maxHeight: dynamic = undefined,

    override val maxWidth: dynamic = undefined,

    override val minHeight: dynamic = undefined,

    override val minWidth: dynamic = undefined,

    override val overflow: dynamic = undefined,

    override val padding: dynamic = undefined,

    override val paddingBottom: dynamic = undefined,

    override val paddingEnd: dynamic = undefined,

    override val paddingHorizontal: dynamic = undefined,

    override val paddingLeft: dynamic = undefined,

    override val paddingRight: dynamic = undefined,

    override val paddingStart: dynamic = undefined,

    override val paddingTop: dynamic = undefined,

    override val paddingVertical: dynamic = undefined,

    override val position: dynamic = undefined,

    override val right: dynamic = undefined,

    override val start: dynamic = undefined,

    override val top: dynamic = undefined,

    override val width: dynamic = undefined,

    override val zIndex: Number? = undefined,
    override val borderBottomWidth: Number? = undefined,
    override val borderLeftWidth: Number? = undefined,
    override val borderRightWidth: Number? = undefined,
    override val borderTopWidth: Number? = undefined,
    override val borderWidth: Number? = undefined,
    override var borderColor: dynamic = undefined,
    override var backgroundColor: String? = undefined

) : LayoutStyle

interface ShadowStyle : LayoutStyle {
    val shadowColor: String?
    val shadowOffset: dynamic
    val shadowOpacity: Number?
    val shadowRadius: Number?

    override val alignContent: dynamic

    override val alignItems: dynamic

    override val alignSelf: dynamic

    override val aspectRatio: Number?

    override val borderEndWidth: dynamic

    override val borderStartWidth: dynamic

    override val bottom: dynamic

    override val direction: dynamic

    override val display: dynamic

    override val end: dynamic

    override val flex: Number?

    override val flexBasis: dynamic

    override val flexDirection: dynamic

    override val flexGrow: Number?

    override val flexShrink: Number?

    override val flexWrap: dynamic

    override val height: dynamic

    override val justifyContent: dynamic

    override val left: dynamic

    override val margin: dynamic

    override val marginBottom: dynamic

    override val marginEnd: dynamic

    override val marginHorizontal: dynamic

    override val marginLeft: dynamic

    override val marginRight: dynamic

    override val marginStart: dynamic

    override val marginTop: dynamic

    override val marginVertical: dynamic

    override val maxHeight: dynamic

    override val maxWidth: dynamic

    override val minHeight: dynamic

    override val minWidth: dynamic

    override val overflow: dynamic

    override val padding: dynamic

    override val paddingBottom: dynamic

    override val paddingEnd: dynamic

    override val paddingHorizontal: dynamic

    override val paddingLeft: dynamic

    override val paddingRight: dynamic

    override val paddingStart: dynamic

    override val paddingTop: dynamic

    override val paddingVertical: dynamic

    override val position: dynamic

    override val right: dynamic

    override val start: dynamic

    override val top: dynamic

    override val width: dynamic

    override val zIndex: Number?

}

class ImageStyle(
    val borderTopRightRadius: Number? = undefined,
    val backfaceVisibility: String? = undefined,
    val borderBottomLeftRadius: Number? = undefined,
    val borderBottomRightRadius: Number? = undefined,
    override var borderColor: String? = undefined,
    val borderRadius: Number? = undefined,
    val borderTopLeftRadius: Number? = undefined,
    val opacity: Number? = undefined,
    val resizeMode: String? = undefined,
    val tintColor: String? = undefined,
    val overlayColor: String? = undefined,

    override val alignContent: dynamic = undefined,

    override val alignItems: dynamic = undefined,

    override val alignSelf: dynamic = undefined,

    override val aspectRatio: Number? = undefined,

    override val borderEndWidth: dynamic = undefined,

    override val borderStartWidth: dynamic = undefined,

    override val bottom: dynamic = undefined,

    override val direction: dynamic = undefined,

    override val display: dynamic = undefined,

    override val end: dynamic = undefined,

    override val flex: Number? = undefined,

    override val flexBasis: dynamic = undefined,

    override val flexDirection: dynamic = undefined,

    override val flexGrow: Number? = undefined,

    override val flexShrink: Number? = undefined,

    override val flexWrap: dynamic = undefined,

    override val height: dynamic = undefined,

    override val justifyContent: dynamic = undefined,

    override val left: dynamic = undefined,

    override val margin: dynamic = undefined,

    override val marginBottom: dynamic = undefined,

    override val marginEnd: dynamic = undefined,

    override val marginHorizontal: dynamic = undefined,

    override val marginLeft: dynamic = undefined,

    override val marginRight: dynamic = undefined,

    override val marginStart: dynamic = undefined,

    override val marginTop: dynamic = undefined,

    override val marginVertical: dynamic = undefined,

    override val maxHeight: dynamic = undefined,

    override val maxWidth: dynamic = undefined,

    override val minHeight: dynamic = undefined,

    override val minWidth: dynamic = undefined,

    override val overflow: dynamic = undefined,

    override val padding: dynamic = undefined,

    override val paddingBottom: dynamic = undefined,

    override val paddingEnd: dynamic = undefined,

    override val paddingHorizontal: dynamic = undefined,

    override val paddingLeft: dynamic = undefined,

    override val paddingRight: dynamic = undefined,

    override val paddingStart: dynamic = undefined,

    override val paddingTop: dynamic = undefined,

    override val paddingVertical: dynamic = undefined,

    override val position: dynamic = undefined,

    override val right: dynamic = undefined,

    override val start: dynamic = undefined,

    override val top: dynamic = undefined,

    override val width: dynamic = undefined,

    override val zIndex: Number? = undefined,
    override val borderBottomWidth: Number? = undefined,
    override val borderLeftWidth: Number? = undefined,
    override val borderRightWidth: Number? = undefined,
    override val borderTopWidth: Number? = undefined,
    override val borderWidth: Number? = undefined,
    override val shadowColor: String? = undefined,
    override val shadowOffset: dynamic = undefined,
    override val shadowOpacity: Number? = undefined,
    override val shadowRadius: Number? = undefined,
    override var backgroundColor: String? = undefined
) : ShadowStyle
