package com.mercadolibre.camilogo1200.utils

import android.view.View


fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.makeVisibleElseGone(makeVisible: Boolean) {
    visibility = if (makeVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun View.makeVisibleElseInvisible(makeVisible: Boolean) {
    visibility = if (makeVisible) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.isGone() = visibility == View.GONE

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.isInvisible() = visibility == View.INVISIBLE


fun View.disable() {
    isEnabled = false
}

fun View.enable() {
    isEnabled = true
}
