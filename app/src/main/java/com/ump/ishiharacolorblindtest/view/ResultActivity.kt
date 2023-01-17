package com.ump.ishiharacolorblindtest.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ump.ishiharacolorblindtest.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private var normalProgress = 0
    private var partialProgress = 0
    private var totalProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        normal()
        partialColorBlind()
        totalColorBlind()
    }

    private fun normal() {
        binding.apply {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed(object : Runnable {
                override fun run() {
                    if (this@ResultActivity.normalProgress <= 60) {
                        tvNormalPercentage.text =
                            StringBuilder().append(this@ResultActivity.normalProgress).append("%")
                        normalProgress.progress = this@ResultActivity.normalProgress
                        this@ResultActivity.normalProgress++
                        handler.postDelayed(this, 20L)
                    } else {
                        handler.removeCallbacks(this)
                    }
                }

            }, 20L)
        }
    }

    private fun partialColorBlind() {
        binding.apply {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed(object : Runnable {
                override fun run() {
                    if (partialProgress <= 30) {
                        tvPartialColorBlindPercentage.text =
                            StringBuilder().append(partialProgress).append("%")
                        partialColorBlindProgress.progress = partialProgress
                        partialProgress++
                        handler.postDelayed(this, 20L)
                    } else {
                        handler.removeCallbacks(this)
                    }
                }

            }, 20L)
        }
    }

    private fun totalColorBlind() {
        binding.apply {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed(object : Runnable {
                override fun run() {
                    if (totalProgress <= 10) {
                        tvTotalColorBlindPercentage.text =
                            StringBuilder().append(totalProgress).append("%")
                        totalColorBlindProgress.progress = totalProgress
                        totalProgress++
                        handler.postDelayed(this, 20L)
                    } else {
                        handler.removeCallbacks(this)
                    }
                }

            }, 20L)
        }
    }
}