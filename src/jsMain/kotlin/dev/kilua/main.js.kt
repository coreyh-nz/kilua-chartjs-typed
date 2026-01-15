package dev.kilua

import dev.kilua.Hot

actual fun bundlerHot(): Hot? {
    return js("import.meta.webpackHot").unsafeCast<Hot?>()
}
