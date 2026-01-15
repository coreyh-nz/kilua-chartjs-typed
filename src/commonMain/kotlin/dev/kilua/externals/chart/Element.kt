package dev.kilua.externals.chart

import kotlin.js.definedExternally

external interface Element {
    var x: Number
    var y: Number
    var active: Boolean
    var options: AnyObject
    fun tooltipPosition(useFinalPosition: Boolean = definedExternally): Point
    fun hasValue(): Boolean
    fun <P : Array<Any>> getProps(props: P, final: Boolean = definedExternally): Any
}