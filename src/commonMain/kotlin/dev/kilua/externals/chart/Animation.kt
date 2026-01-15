package dev.kilua.externals.chart

import kotlin.js.JsAny
import kotlin.js.definedExternally

open external class Animation(cfg: JsAny, target: JsAny, prop: String, to: Any = definedExternally) {
    open fun active(): Boolean
    open fun update(cfg: JsAny, to: Any, date: Number)
    open fun cancel()
    open fun tick(date: Number)
}

external interface AnimationEvent {
    var chart: Chart
    var numSteps: Number
    var initial: Boolean
    var currentStep: Number
}

open external class Animator {
    open fun listen(chart: Chart, event: String /* "complete" | "progress" */, cb: (event: AnimationEvent) -> Unit)
    open fun add(chart: Chart, items: Array<Animation>)
    open fun has(chart: Chart): Boolean
    open fun start(chart: Chart)
    open fun running(chart: Chart): Boolean
    open fun stop(chart: Chart)
    open fun remove(chart: Chart): Boolean
}

open external class Animations(chart: Chart, animations: JsAny) {
    open fun configure(animations: JsAny)
    open fun update(target: JsAny, values: JsAny): Boolean?
}