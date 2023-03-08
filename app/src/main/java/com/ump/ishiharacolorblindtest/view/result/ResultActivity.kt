package com.ump.ishiharacolorblindtest.view.result

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.ump.ishiharacolorblindtest.databinding.ActivityResultBinding
import com.ump.ishiharacolorblindtest.view.base.BaseVBActivity
import com.ump.ishiharacolorblindtest.view.home.HomeActivity
import kotlin.math.roundToLong

class ResultActivity : BaseVBActivity<ActivityResultBinding>() {
    private var normalProgress = 0
    private var partialProgress = 0
    private var totalProgress = 0
    private var normalPercentage = 0L
    private var partialPercentage = 0L
    private var otherPercentage = 0L

    override fun getViewBinding(): ActivityResultBinding =
        ActivityResultBinding.inflate(layoutInflater)

    override fun initView() {
        val plate = intent.getStringExtra(PLATE_FOURTEEN) as String
        val normal = intent.getStringArrayListExtra(NORMAL_RESULT) as ArrayList<String>
        val partial = intent.getStringArrayListExtra(PARTIAL_RESULT) as ArrayList<String>
        val other = intent.getStringArrayListExtra(OTHER_RESULT) as ArrayList<String>

        when (plate) {
            PLATE_FOURTEEN -> {
                normalPercentage = ((normal.size.toDouble() / 14.0) * 100).roundToLong()
                partialPercentage = ((partial.size.toDouble() / 14.0) * 100).roundToLong()
                otherPercentage = ((other.size.toDouble() / 14.0) * 100).roundToLong()
            }
            PLATE_TWENTY_FOUR -> {
                normalPercentage = ((normal.size.toDouble() / 24.0) * 100).roundToLong()
                partialPercentage = ((partial.size.toDouble() / 24.0) * 100).roundToLong()
                otherPercentage = ((other.size.toDouble() / 24.0) * 100).roundToLong()
            }
            PLATE_THIRTY_EIGHT -> {
                normalPercentage = ((normal.size.toDouble() / 38.0) * 100).roundToLong()
                partialPercentage = ((partial.size.toDouble() / 38.0) * 100).roundToLong()
                otherPercentage = ((other.size.toDouble() / 38.0) * 100).roundToLong()
            }
        }

        normal()
        partialColorBlind()
        totalColorBlind()

        binding.imgBack.setOnClickListener { onBackPressed() }
    }

    private fun normal() {
        binding.apply {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed(object : Runnable {
                override fun run() {
                    // why (normalPercentage + 1) ? so that the final result meets the number 100
                    val totalPercentage = normalPercentage + partialPercentage + otherPercentage
                    val percentage =
                        if (totalPercentage == 100L) normalPercentage else normalPercentage + 1
                    if (normalProgress <= percentage) {
                        tvNormalPercentage.text = StringBuilder().append(normalProgress).append("%")
                        normalColorBlindProgress.progress = normalProgress
                        normalProgress++
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
                    if (partialProgress <= partialPercentage) {
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
                    if (totalProgress <= otherPercentage) {
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

    override fun onBackPressed() {
        Intent(this, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
            finish()
        }
    }

    companion object {
        const val NORMAL_RESULT = "NORMAL RESULT"
        const val PARTIAL_RESULT = "PARTIAL RESULT"
        const val OTHER_RESULT = "OTHER_RESULT"
        const val PLATE_FOURTEEN = "PLATE FOURTEEN"
        const val PLATE_TWENTY_FOUR = "PLATE TWENTY-FOUR"
        const val PLATE_THIRTY_EIGHT = "PLATE THIRTY-EIGHT"
    }
}