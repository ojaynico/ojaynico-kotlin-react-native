@file:Suppress("unused")

package ojaynico.kotlin.react

import ojaynico.kotlin.react.native.api.AppRegistry
import react.Component

// Components

inline fun <reified T : Component<*, *>> AppRegistry.registerComponent(name: String) {
    registerComponent(name) { T::class.js }
}

// JS

inline fun json(init: dynamic.() -> Unit): dynamic {
  val o = json()
  init(o)
  return o
}

@Suppress("NOTHING_TO_INLINE")
inline fun json(): dynamic = js("{}")
