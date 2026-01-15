package dev.kilua.externals.chart

import kotlin.js.definedExternally

external interface DateAdapter {
    fun override(members: DateAdapterPartial)
    var options: Any
    fun formats(): dynamic
    fun parse(
        value: Any,
        format: String /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */ = definedExternally
    ): Number?

    fun format(
        timestamp: Number,
        format: String /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */
    ): String

    fun add(
        timestamp: Number,
        amount: Number,
        unit: String /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */
    ): Number

    fun diff(
        a: Number,
        b: Number,
        unit: String /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */
    ): Number

    fun startOf(
        timestamp: Number,
        unit: String /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" | "isoWeek" */,
        weekday: Number = definedExternally
    ): Number

    fun endOf(
        timestamp: Number,
        unit: String /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" | "isoWeek" */
    ): Number
}

external interface DateAdapterPartial {
    var override: ((members: dynamic) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var options: Any?
        get() = definedExternally
        set(value) = definedExternally
    var formats: (() -> dynamic)?
        get() = definedExternally
        set(value) = definedExternally
    var parse: ((value: Any, format: String? /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */) -> Number?)?
        get() = definedExternally
        set(value) = definedExternally
    var format: ((timestamp: Number, format: String? /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */) -> String)?
        get() = definedExternally
        set(value) = definedExternally
    var add: ((timestamp: Number, amount: Number, unit: String? /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */) -> Number)?
        get() = definedExternally
        set(value) = definedExternally
    var diff: ((a: Number, b: Number, unit: String? /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" */) -> Number)?
        get() = definedExternally
        set(value) = definedExternally
    var startOf: ((timestamp: Number, unit: String? /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" | "isoWeek" */, weekday: Number) -> Number)?
        get() = definedExternally
        set(value) = definedExternally
    var endOf: ((timestamp: Number, unit: String? /* "millisecond" | "second" | "minute" | "hour" | "day" | "week" | "month" | "quarter" | "year" | "isoWeek" */) -> Number)?
        get() = definedExternally
        set(value) = definedExternally
}