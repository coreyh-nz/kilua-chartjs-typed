package dev.kilua.externals.chart

import kotlin.js.definedExternally

external interface LayoutItem {
    var position: dynamic /* "left" | "top" | "right" | "bottom" | "center" | "chartArea" | `T$49` */
        get() = definedExternally
        set(value) = definedExternally
    var weight: Number
    var fullSize: Boolean
    var width: Number
    var height: Number
    var left: Number
    var top: Number
    var right: Number
    var bottom: Number
    val beforeLayout: (() -> Unit)?
    fun draw(chartArea: ChartArea)
    val getPadding: (() -> ChartArea)?
    fun isHorizontal(): Boolean
    fun update(width: Number, height: Number, margins: ChartArea = definedExternally)
}