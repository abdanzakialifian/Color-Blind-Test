package com.ump.ishiharacolorblindtest.helper

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.view.splash.SplashScreenActivity
import java.util.*
import kotlin.system.exitProcess

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun TextView.textColorWhite(context: Context) {
    this.setTextColor(
        ContextCompat.getColor(
            context,
            R.color.white
        )
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

fun Context.restartApp() {
    val t = Timer()
    t.schedule(
        object : TimerTask() {
            override fun run() {
                startActivity(Intent(this@restartApp, SplashScreenActivity::class.java))
                exitProcess(0)
                t.cancel()
            }
        },
        200
    )
}

