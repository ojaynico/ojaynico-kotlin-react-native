package ojaynico.kotlin.react

import ojaynico.kotlin.react.navigator.Navigator
import ojaynico.kotlin.react.navigator.Route
import ojaynico.kotlin.react.navigator.RouteProps
import react.Props
import react.RBuilder
import react.RElementBuilder

fun RBuilder.navigator(handler: RElementBuilder<Props>.() -> Unit) = child(Navigator::class) {
    handler()
}

fun RBuilder.route(handler: RElementBuilder<RouteProps>.() -> Unit) = child(Route) {
    handler()
}
