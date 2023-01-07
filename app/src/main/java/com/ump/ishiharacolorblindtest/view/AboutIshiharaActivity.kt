package com.ump.ishiharacolorblindtest.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.ump.ishiharacolorblindtest.databinding.ActivityAboutIshiharaBinding
import com.ump.ishiharacolorblindtest.helper.FontSize


class AboutIshiharaActivity : BaseVBActivity<ActivityAboutIshiharaBinding>() {

    private lateinit var prefs: SharedPreferences

    override fun getViewBinding(): ActivityAboutIshiharaBinding =
        ActivityAboutIshiharaBinding.inflate(layoutInflater)

    @SuppressLint("SourceLockedOrientationActivity")
    override fun initView() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        prefs = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

        adjustFontScale(resources.configuration)

        binding.imgPlus.setOnClickListener {
            when (prefs.getFloat(FONT_SCALE, 1F)) {
                FontSize.DEFAULT.scale -> {
                    updateFontSize(FontSize.LARGE.scale, prefs)
                }
                FontSize.LARGE.scale -> {
                    updateFontSize(FontSize.EXTRA.scale, prefs)
                }
                FontSize.EXTRA.scale -> {
                    updateFontSize(FontSize.DEFAULT.scale, prefs)
                }
            }
        }
    }

    private fun updateFontSize(fontSize: Float, prefs: SharedPreferences) {
        prefs.edit()
            .putFloat(FONT_SCALE, fontSize)
            .apply()
        recreate()
    }

    @Suppress("DEPRECATION")
    private fun adjustFontScale(configuration: Configuration) {
        configuration.fontScale = prefs.getFloat(FONT_SCALE, 1F)
        val metrics = resources.displayMetrics
        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density
        baseContext.resources.updateConfiguration(configuration, metrics)
    }

    companion object {
        private const val SHARED_PREFERENCES = "Shared Preferences"
        private const val FONT_SCALE = "Font Scale"
    }
}
