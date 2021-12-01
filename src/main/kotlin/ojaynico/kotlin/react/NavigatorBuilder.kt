package ojaynico.kotlin.react

import ojaynico.kotlin.react.navigator.Navigator
import ojaynico.kotlin.react.navigator.NavigatorProps
import ojaynico.kotlin.react.navigator.Route
import ojaynico.kotlin.react.navigator.RouteProps
import react.RBuilder
import react.RElementBuilder

fun RBuilder.navigator(handler: RElementBuilder<NavigatorProps>.() -> Unit) = child(Navigator::class) {
    handler()
}

fun RBuilder.route(handler: RElementBuilder<RouteProps>.() -> Unit) = child(Route) {
    handler()
}
