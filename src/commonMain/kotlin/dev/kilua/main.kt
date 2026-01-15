package dev.kilua

import dev.kilua.chart.charts
import dev.kilua.html.div
import dev.kilua.compose.root
import js.objects.unsafeJso

class App : Application() {
    override fun start() {
        root("root") {
            div {
                +"Earthquake Building Levels"
            }

            charts(config = unsafeJso {
                type = "line"
            }) {
                configureChart {
                    data.apply {
                        labels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6")
                        datasets = arrayOf(
                            unsafeJso<dynamic> {
                                type = "line"
                                label = "Seismic Response"
                                this.data = arrayOf(0.2, 0.5, 1.2, 0.8, 0.6, 0.3) // example sensor readings per level
                                fill = false
                                borderColor = "rgba(255, 99, 132, 1)" // line color
                                backgroundColor = "rgba(255, 99, 132, 0.2)" // point color
                                tension = 0.3 // smooth curve
                                pointRadius = 6
                                pointHoverRadius = 8
                                borderWidth = 2
                            }
                        )
                    }
                }
            }
        }
    }
}

fun main() {
    startApplication(
        ::App,
        bundlerHot(),
        CoreModule,
        ChartModule
    )
}

expect fun bundlerHot(): Hot?
