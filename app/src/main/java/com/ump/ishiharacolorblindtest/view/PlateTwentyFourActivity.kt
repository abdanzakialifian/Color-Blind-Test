package com.ump.ishiharacolorblindtest.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.adapter.MultipleChoiceAdapter
import com.ump.ishiharacolorblindtest.databinding.ActivityPlateTwentyFourBinding
import com.ump.ishiharacolorblindtest.helper.QuestionList
import com.ump.ishiharacolorblindtest.helper.gone
import com.ump.ishiharacolorblindtest.helper.visible
import com.ump.ishiharacolorblindtest.model.QuestionData
import com.ump.ishiharacolorblindtest.view.ResultActivity.Companion.NORMAL_RESULT
import com.ump.ishiharacolorblindtest.view.ResultActivity.Companion.OTHER_RESULT
import com.ump.ishiharacolorblindtest.view.ResultActivity.Companion.PARTIAL_RESULT
import com.ump.ishiharacolorblindtest.view.ResultActivity.Companion.PLATE_FOURTEEN
import com.ump.ishiharacolorblindtest.view.ResultActivity.Companion.PLATE_TWENTY_FOUR

class PlateTwentyFourActivity : BaseVBActivity<ActivityPlateTwentyFourBinding>() {
    private lateinit var questionList: List<QuestionData>
    private val normalAnswer = ArrayList<String>()
    private val partialAnswer = ArrayList<String>()
    private val otherAnswer = ArrayList<String>()
    private var currentPage: Int = 1
    private var currentPoint: Int = 0
    private var myAnswer: String = ""

    override fun getViewBinding(): ActivityPlateTwentyFourBinding =
        ActivityPlateTwentyFourBinding.inflate(layoutInflater)

    @SuppressLint("SourceLockedOrientationActivity")
    override fun initView() {
        // make fullscreen
        fullScreen(window, supportActionBar)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // set screen brightness
        // 13 * 1 -> 5% brightness dikali 2 jadi 10% dst
        val brightness: Float = (13 * 1) / 255f
        val layout = window.attributes
        layout.screenBrightness = brightness
        window.attributes = layout

        binding.imgBack.setOnClickListener {
            alertDialogOnBackPressed()
        }

        // generate question plate fourteen
        questionList = QuestionList.getAllQuestionTwentyFour()

        startQuiz()
    }

    private fun startQuiz() {
        binding.apply {
            val question = questionList[currentPage - 1]

            tvPage.text = resources.getString(R.string.page, currentPage.toString())

            tvQuestion.text = resources.getString(R.string.what_do_you_see)

            Glide.with(this@PlateTwentyFourActivity)
                .load(resources.getIdentifier(question.image, "drawable", packageName))
                .into(imgQuestion)

            if (currentPage == questionList.size) {
                btnSubmit.text = resources.getString(R.string.finished)
            }

            if (question.id in 1..13 || question.id in 16..17) {
                edtField.visible()
                rvMultipleChoice.gone()

                edtField.addTextChangedListener {
                    myAnswer = it.toString()
                    if (it.toString().isNotEmpty())
                        stateButton(true)
                    else
                        stateButton(false)
                }

                layoutParent.setOnClickListener {
                    hideKeyboard(it)
                }
            } else {
                edtField.gone()
                rvMultipleChoice.visible()

                val listQuestionChoice = ArrayList<String>()
                if (question.optionOne != "") {
                    listQuestionChoice.add(question.optionOne)
                }
                if (question.optionTwo != "") {
                    listQuestionChoice.add(question.optionTwo)
                }
                if (question.optionThree != "") {
                    listQuestionChoice.add(question.optionThree)
                }
                if (question.optionFour != "") {
                    listQuestionChoice.add(question.optionFour)
                }

                val adapter = MultipleChoiceAdapter()
                adapter.setListMultipleChoice(listQuestionChoice)
                if (question.id in 14..15 || question.id == 21) {
                    rvMultipleChoice.layoutManager = GridLayoutManager(this@PlateTwentyFourActivity, 3)
                } else {
                    rvMultipleChoice.layoutManager = GridLayoutManager(this@PlateTwentyFourActivity, 2)
                }
                adapter.setOnItemClickCallback(object : MultipleChoiceAdapter.OnItemClickCallback {
                    override fun onItemClicked(answer: String) {
                        myAnswer = answer
                        stateButton(true)
                    }
                })
                rvMultipleChoice.adapter = adapter
                rvMultipleChoice.setHasFixedSize(true)
            }

            btnSubmit.setOnClickListener {
                // save answer to list
                saveAnswer(question.id, question.correctAnswer)

                // disable input and button after click
                stateButton(false)

                if (myAnswer == question.correctAnswer) {
                    // add the point
                    currentPoint++
                }

                nextQuestion()
            }
        }
    }

    private fun saveAnswer(questionId: Int, correctAnswer: String) {
        when (questionId) {
            1 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            2 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "3" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            3 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "70" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            4 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "2" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            5 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "5" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            6 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "17" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            7 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "21" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            8 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "8" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            9 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "15" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            10 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "2" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            11 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "2" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            12 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "18" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            13 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "13" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            14 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "number_five" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            15 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "number_forty_five" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            16 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "6" -> partialAnswer.add(myAnswer)
                "2" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            17 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "4" -> partialAnswer.add(myAnswer)
                "2" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            18 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "line_purple" -> partialAnswer.add(myAnswer)
                "line_red" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            19 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "line_orange" -> partialAnswer.add(myAnswer)
                "line_green" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            20 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "line_blue" -> partialAnswer.add(myAnswer)
                "line_green" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            21 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "line_red" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            22 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "line_blue_green_and_line_purple" -> partialAnswer.add(myAnswer)
                "line_yellow_green_and_line_blue" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            23 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                "line_purple" -> partialAnswer.add(myAnswer)
                "line_red" -> partialAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
            24 -> when (myAnswer) {
                correctAnswer -> normalAnswer.add(myAnswer)
                else -> otherAnswer.add(myAnswer)
            }
        }
    }

    private fun nextQuestion() {
        // change the question
        currentPage++

        if (currentPage <= questionList.size) {
            binding.edtField.apply {
                text?.clear()
                isEnabled = true
            }
            startQuiz()
        } else {
            Intent(this, ResultActivity::class.java).apply {
                putExtra(PLATE_FOURTEEN, PLATE_TWENTY_FOUR)
                putExtra(NORMAL_RESULT, normalAnswer)
                putExtra(PARTIAL_RESULT, partialAnswer)
                putExtra(OTHER_RESULT, otherAnswer)
                startActivity(this)
            }
            finish()
        }
        myAnswer = ""
    }

    private fun stateButton(state: Boolean) {
        binding.btnSubmit.isEnabled = state
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun alertDialogOnBackPressed() {
        val dialog = AlertDialog.Builder(this)
            .setTitle(resources.getString(R.string.back_to_main_menu))
            .setMessage(resources.getString(R.string.deleted_sesi_information))
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, _ ->
                fullScreen(window, supportActionBar)
                dialog.cancel()
            }
            .setOnCancelListener { fullScreen(window, supportActionBar) }
            .setPositiveButton(resources.getString(R.string.ok)) { _, _ ->
                fullScreen(window, supportActionBar)
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

    @Suppress("DEPRECATION")
    private fun fullScreen(window: Window, supportActionBar: ActionBar?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        binding.apply {
            if (!hasFocus) {
                layoutQuestion.gone()
                layoutLostFocus.visible()
            } else {
                layoutQuestion.visible()
                layoutLostFocus.gone()
            }
        }
    }

    override fun onBackPressed() {
        alertDialogOnBackPressed()
    }
}