package com.ump.ishiharacolorblindtest.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.databinding.ActivityHomeBinding

class HomeActivity : BaseVBActivity<ActivityHomeBinding>() {

    private var backPressedTime = 0L

    override fun getViewBinding(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)

    @SuppressLint("SourceLockedOrientationActivity")
    override fun initView() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding.apply {
            cvAboutIshihara.setOnClickListener {
                startActivity(Intent(this@HomeActivity, AboutIshiharaActivity::class.java))
            }

            cvColorBlintTestOne.setOnClickListener {
                startActivity(Intent(this@HomeActivity, PlateFourteenActivity::class.java))
            }

            cvColorBlintTestTwo.setOnClickListener {
                startActivity(Intent(this@HomeActivity, PlateTwentyFourActivity::class.java))
            }
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + DELAY_BACK_PRESSED > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(
                this,
                resources.getString(R.string.back_press_information),
                Toast.LENGTH_LONG
            ).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    companion object {
        private const val DELAY_BACK_PRESSED = 3000L
    }
}