package com.ump.ishiharacolorblindtest.view.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.ump.ishiharacolorblindtest.BuildConfig
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.databinding.ActivitySplashScreenBinding
import com.ump.ishiharacolorblindtest.view.about.AboutIshiharaActivity
import com.ump.ishiharacolorblindtest.view.base.BaseVBActivity
import com.ump.ishiharacolorblindtest.view.home.HomeActivity

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreenActivity : BaseVBActivity<ActivitySplashScreenBinding>() {

    private lateinit var prefs: SharedPreferences

    override fun getViewBinding(): ActivitySplashScreenBinding =
        ActivitySplashScreenBinding.inflate(layoutInflater)

    @SuppressLint("SourceLockedOrientationActivity")
    override fun initView() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        prefs = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

        adjustFontScale(resources.configuration)

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        binding.appVersion.text =
            resources.getString(R.string.app_version, BuildConfig.VERSION_NAME)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, DELAY_SPLASH_SCREEN)
    }

    @Suppress("DEPRECATION")
    private fun adjustFontScale(configuration: Configuration) {
        configuration.fontScale = prefs.getFloat(FONT_SCALE, 1F)
        Log.d("CEK", configuration.fontScale.toString())
        val metrics = resources.displayMetrics
        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density
        baseContext.resources.updateConfiguration(configuration, metrics)
    }

    companion object {
        private const val DELAY_SPLASH_SCREEN = 3000L
        private const val SHARED_PREFERENCES = "Shared Preferences"
        private const val FONT_SCALE = "Font Scale"
    }
}