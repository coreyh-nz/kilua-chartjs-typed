package dev.kilua

import dev.kilua.compose.root

class App : Application() {
    override fun start() {
        root("root") {

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
