package dev.kilua

import kotlin.js.js

object ChartModule : ModuleInitializer {
    override fun initialize() {
        // Workaround CommonJS problems with Chart.js 4
        js("import('chart.js/auto')")
    }
}