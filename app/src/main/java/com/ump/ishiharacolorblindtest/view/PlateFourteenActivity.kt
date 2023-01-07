package com.ump.ishiharacolorblindtest.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.CompoundButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.databinding.ActivityPlatFourteenBinding
import com.ump.ishiharacolorblindtest.helper.QuestionList
import com.ump.ishiharacolorblindtest.model.QuestData
import com.ump.ishiharacolorblindtest.model.SavedAnswerData

class PlateFourteenActivity : BaseVBActivity<ActivityPlatFourteenBinding>() {
    private var questionList: List<QuestData>? = null
    private var currentPos: Int = 1
    private var myAnswer: String = ""
    private var currentPoint: Int = 0
    private var savedAnswer: ArrayList<SavedAnswerData>? = arrayListOf()
    private var checkedCb: CompoundButton? = null

    override fun getViewBinding(): ActivityPlatFourteenBinding =
        ActivityPlatFourteenBinding.inflate(layoutInflater)

    @SuppressLint("SourceLockedOrientationActivity")
    override fun initView() {
        // make fullscreen
        fullscreen(window, supportActionBar)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // set screen brightness
        // 13 * 1 -> 5% brightness dikali 2 jadi 10% dst
        val brightness: Float = (13 * 1) / 255f
        val layout = window.attributes
        layout.screenBrightness = brightness
        window.attributes = layout

        binding.imgBack.setOnClickListener {
            alertOnBackPressed()
        }

        // generate question
        questionList = QuestionList.getAllQuestion()

        startQuiz()
    }

    private fun startQuiz() {
        val q = questionList!![currentPos - 1]
        Log.d("asd quest now", "$q")

        // tampilkan posisi halaman
        binding.progressSoal.text =
            resources.getString(
                R.string.halaman_proses,
                currentPos.toString()
            )

        // tampilkan soal
        Glide.with(this)
            .load(resources.getIdentifier(q.questionImage, "drawable", packageName))
            .into(binding.imageView8) // imageView mana yang akan diterapkan

        if (q.questionImage.substring(0, 5) == "angka") {
            binding.textField.visibility = View.VISIBLE
            binding.radioImageGroup.visibility = View.GONE

            binding.perintahSoal.text = resources.getString(R.string.text_for_essay)

            // soal skrng adalah angka, maka tampilkan text input untuk jawaban essay
            binding.textFieldEditText.apply {
                this.transformationMethod = null
                this.addTextChangedListener {
                    // change submit button
                    myAnswer = it.toString()
                    if (it.toString().isNotEmpty())
                        btnEnable(true)
                    else
                        btnEnable(false)
                }
            }

            binding.parent.setOnClickListener {
                hideKeyboard(it)
            }
        } else {
            binding.textField.visibility = View.GONE
            binding.radioImageGroup.visibility = View.VISIBLE

            when (currentPos) {
                11 -> binding.perintahSoal.text = resources.getString(
                    R.string.text_for_multiple_choice,
                    resources.getString(R.string.text_mc_11)
                )
                14 -> binding.perintahSoal.text =
                    "Ikuti garis dari X ke X pada pelat, cocokan dengan gambar yang ada dibawah"
                else -> binding.perintahSoal.text = resources.getString(R.string.text_for_essay)
            }
            // soal skrng adalah garis, tampilkan pilihan ganda

            val answerOptions = arrayListOf(q.opt1, q.opt2, q.opt3)

            binding.imgOption1.apply {
                setImageResource(
                    resources.getIdentifier(
                        answerOptions[0], "drawable", packageName
                    )
                )
                setOnClickListener {
                    binding.checkbox1.isChecked = true
                    binding.checkbox2.isChecked = false
                    binding.checkbox3.isChecked = false
                }
            }
            binding.imgOption2.apply {
                setImageResource(
                    resources.getIdentifier(
                        answerOptions[1], "drawable", packageName
                    )
                )
                setOnClickListener {
                    binding.checkbox1.isChecked = false
                    binding.checkbox2.isChecked = true
                    binding.checkbox3.isChecked = false
                }
            }
            binding.imgOption3.apply {
                setImageResource(
                    resources.getIdentifier(
                        answerOptions[2], "drawable", packageName
                    )
                )
                setOnClickListener {
                    binding.checkbox1.isChecked = false
                    binding.checkbox2.isChecked = false
                    binding.checkbox3.isChecked = true
                }
            }

            binding.checkbox1.apply {
                text = answerOptions[0]
                setOnCheckedChangeListener { compoundButton, ischecked ->
                    if (ischecked) {
                        myAnswer = compoundButton.text as String
                        checkedCb = compoundButton
                        this@PlateFourteenActivity.changeCbView(1)
                        btnEnable(true)
                    }
                }
            }
            binding.checkbox2.apply {
                text = answerOptions[1]
                setOnCheckedChangeListener { compoundButton, ischecked ->
                    if (ischecked) {
                        myAnswer = compoundButton.text as String
                        checkedCb = compoundButton
                        this@PlateFourteenActivity.changeCbView(2)
                        btnEnable(true)
                    }
                }
            }
            binding.checkbox3.apply {
                text = answerOptions[2]
                setOnCheckedChangeListener { compoundButton, ischecked ->
                    if (ischecked) {
                        myAnswer = compoundButton.text as String
                        checkedCb = compoundButton
                        this@PlateFourteenActivity.changeCbView(3)
                        btnEnable(true)
                    }
                }
            }
        }

        if (currentPos == questionList!!.size) {
            binding.submitButtton.text = "Selesai"
        }

        binding.submitButtton.setOnClickListener {
            // save answer
            saveAnswer(q.id.toString(), q.questionImage, myAnswer, q.correctAns)

            // disable input and button after click
            btnEnable(false)

            binding.textFieldEditText.isEnabled = false

            if (myAnswer == q.correctAns) {
                // add the point
                currentPoint++
            } else {
            }
            nextQuestion()
        }
    }

    private fun nextQuestion() {
        // change the question
        currentPos++

        when {
            currentPos <= questionList!!.size -> {
                // going to then next question and clear the text field

                // cek soal pilihan ganda atau essay
                binding.textFieldEditText.apply {
                    text?.clear()
                    isEnabled = true
                }

                if (checkedCb?.isChecked == true) {
                    this@PlateFourteenActivity.changeCbView(null)
                }

                checkedCb?.isChecked = false

                startQuiz()
            }
            else -> {
                Intent(this, ScoreActivity::class.java).apply {
                    this.putExtra("TEST_RESULT", savedAnswer)
                    startActivity(this)
                }
                finish()
            }
        }
        myAnswer = ""
    }

    private fun saveAnswer(
        questionNumber: String,
        question: String,
        myAnswer: String,
        correctAns: String
    ) {
        savedAnswer?.add(
            SavedAnswerData(
                questionNumber,
                question,
                myAnswer,
                correctAns
            )
        )
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    private fun btnEnable(state: Boolean) {
        when {
            // ubah menjadi enable
            state -> {
                binding.submitButtton.apply {
                    isEnabled = true
                    backgroundTintList =
                        ContextCompat.getColorStateList(
                            this@PlateFourteenActivity,
                            R.color.blue_700
                        )
                    setTextColor(Color.parseColor("#FFFFFF"))
                }
            }
            // ubah menjadi disable
            else -> {
                binding.submitButtton.apply {
                    isEnabled = false
                    backgroundTintList =
                        ContextCompat.getColorStateList(this@PlateFourteenActivity, R.color.white)
                    setTextColor(Color.parseColor("#37A3FE"))
                }
            }
        }
    }

    //    KEPENTINGAN CUMA SAMPE INI.
    private fun hideKeyboard(view: View) {
        val inputMethodManager: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onBackPressed() {
        alertOnBackPressed()
    }

    private fun alertOnBackPressed() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Kembali ke menu utama?")
            .setMessage("Sesi ini akan dihapus jika anda keluar sekarang.")
            .setNegativeButton("Batal") { dialog, _ ->
                fullscreen(window, supportActionBar)
                dialog.cancel()
            }
            .setOnCancelListener { fullscreen(window, supportActionBar) }
            .setPositiveButton("Ok") { _, _ ->
                fullscreen(window, supportActionBar)
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }.create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(ContextCompat.getColor(this, R.color.blue_700))

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(ContextCompat.getColor(this, R.color.yellow_700))
        }

        dialog.show()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.d("Focus debug", "Focus changed !")
        if (!hasFocus) {
            Log.d("Focus debug", "Lost focus !")
            binding.lostFocus.visibility = View.VISIBLE
            binding.submitButtton.visibility = View.GONE
        } else {
            binding.lostFocus.visibility = View.GONE
            binding.submitButtton.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        super.onPause()
        binding.lostFocus.visibility = View.VISIBLE
        binding.submitButtton.visibility = View.GONE
    }

    private fun fullscreen(window: Window, supportActionBar: ActionBar?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun changeCbView(opt: Int? = null) {
        binding.textOption1.setTextColor(ContextCompat.getColorStateList(this, R.color.white))
        when (opt) {
            1 -> {
                binding.textOption2.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.textOption3.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.wrapCb1.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.blue_700)
                binding.wrapCb2.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
                binding.wrapCb3.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
            }
            2 -> {
                binding.textOption1.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.textOption2.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.white
                    )
                )
                binding.textOption3.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.wrapCb1.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
                binding.wrapCb2.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.blue_700)
                binding.wrapCb3.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
            }
            3 -> {
                binding.textOption1.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.textOption2.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.textOption3.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.white
                    )
                )
                binding.wrapCb1.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
                binding.wrapCb2.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
                binding.wrapCb3.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.blue_700)
            }
            else -> {
                binding.textOption1.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.textOption2.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.textOption3.setTextColor(
                    ContextCompat.getColorStateList(
                        this,
                        R.color.black
                    )
                )
                binding.wrapCb1.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
                binding.wrapCb2.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
                binding.wrapCb3.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.white)
            }
        }
    }
}