package com.ump.ishiharacolorblindtest.helper

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ump.ishiharacolorblindtest.R

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun LinearLayout.blueBackgroundRound10(context: Context) {
    this.background = ContextCompat.getDrawable(
        context,
        R.drawable.bg_blue_rounded_10
    )
}

fun TextView.textColorWhite(context: Context) {
    this.setTextColor(
        ContextCompat.getColor(
            context,
            R.color.white
        )
    )
}

fun LinearLayout.whiteBackgroundRound10(context: Context) {
    this.background = ContextCompat.getDrawable(
        context,
        R.drawable.bg_white_rounded_10
    )
}

fun TextView.textColorBlack(context: Context) {
    this.setTextColor(
        ContextCompat.getColor(
            context,
            R.color.black
        )
    )
}

