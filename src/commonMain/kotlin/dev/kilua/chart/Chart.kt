package dev.kilua.chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import dev.kilua.compose.ComponentNode
import dev.kilua.core.IComponent
import dev.kilua.core.RenderConfig
import dev.kilua.externals.chart.Chart as JsChart
import dev.kilua.externals.chart.ChartConfiguration
import dev.kilua.html.ITag
import dev.kilua.html.Tag
import web.html.HTMLCanvasElement

interface IChart : ITag<HTMLCanvasElement> {
    var config: ChartConfiguration?
    val chartInstance: JsChart?

    @Composable
    fun config(config: ChartConfiguration?)

    @Composable
    fun configureChart(configure: JsChart.() -> Unit)
}

open class Chart(
    initialConfig: ChartConfiguration? = null,
    className: String? = null,
    id: String? = null,
    renderConfig: RenderConfig = RenderConfig.Default
) : Tag<HTMLCanvasElement>("canvas", className, id, renderConfig = renderConfig), IChart {

    override var chartInstance: JsChart? = null

    private var chartConfigurer: JsChart.() -> Unit = {}

    override var config: ChartConfiguration? by updatingProperty(initialConfig) {
        refresh()
    }

    @Composable
    override fun config(config: ChartConfiguration?) = composableProperty("config", { this.config = null }) {
        this.config = config
    }

    @Composable
    override fun configureChart(configure: JsChart.() -> Unit) {
        chartConfigurer = configure
        refresh()
    }

    override fun onInsert() {
        initializeChart()
    }

    override fun onRemove() {
        destroyChart()
    }

    protected open fun refresh() {
        if (chartInstance != null) {
            destroyChart()
            initializeChart()
        }
    }

    protected open fun initializeChart() {
        if (renderConfig.isDom && config != null) {
            chartInstance = JsChart(element, config!!)
            chartInstance!!.chartConfigurer()
        }
    }

    protected open fun destroyChart() {
        chartInstance?.destroy()
        chartInstance = null
    }
}

@Composable
fun IComponent.chartsRef(
    config: ChartConfiguration? = null,
    className: String? = null,
    id: String? = null,
    content: @Composable IChart.() -> Unit = {}
): Chart {
    val component = remember { Chart(config, className, id, renderConfig = renderConfig) }
    DisposableEffect(component.componentId) {
        component.onInsert()
        onDispose { component.onRemove() }
    }
    ComponentNode(component, {
        set(config) { updateProperty(Chart::config, it) }
        set(className) { updateProperty(Chart::className, it) }
        set(id) { updateProperty(Chart::id, it) }
    }, content)
    return component
}

@Composable
fun IComponent.charts(
    config: ChartConfiguration? = null,
    className: String? = null,
    id: String? = null,
    content: @Composable IChart.() -> Unit = {}
) {
    val component = remember { Chart(config, className, id, renderConfig = renderConfig) }
    DisposableEffect(component.componentId) {
        component.onInsert()
        onDispose { component.onRemove() }
    }
    ComponentNode(component, {
        set(config) { updateProperty(Chart::config, it) }
        set(className) { updateProperty(Chart::className, it) }
        set(id) { updateProperty(Chart::id, it) }
    }, content)
}