package com.ump.ishiharacolorblindtest.helper

import com.ump.ishiharacolorblindtest.model.QuestionData

object QuestionList {
    fun getAllQuestionPlateFourteen(): ArrayList<QuestionData> {
        val listQuestion: ArrayList<QuestionData> = arrayListOf()

        for (i in 1..14) {
            val correctAnswer = arrayListOf(
                "12",
                "8",
                "5",
                "29",
                "74",
                "7",
                "45",
                "2",
                "nothing",
                "16",
                "line_blue_and_line_green",
                "35",
                "96",
                "line_purple_and_line_red"
            )
            val optionOne = when(i) {
                9 -> "number_eight"
                11 -> "line_blue_and_line_green"
                14 -> "nothing"
                else -> ""
            }
            val optionTwo = when(i) {
                9 -> "number_two"
                11 -> "line_green"
                14 -> "line_purple_and_line_red"
                else -> ""
            }
            val optionThree = when(i) {
                9 -> "nothing"
                11 -> "nothing"
                14 -> "line_red"
                else -> ""
            }
            val question = QuestionData(
                id = i,
                image = "plate_14_$i",
                optionOne = optionOne,
                optionTwo = optionTwo,
                optionThree = optionThree,
                correctAnswer = correctAnswer[i - 1]
            )
            listQuestion.add(question)
        }

        return listQuestion
    }

    fun getAllQuestionTwentyFour(): ArrayList<QuestionData> {
        val listQuestion: ArrayList<QuestionData> = arrayListOf()

        for (i in 1..24) {
            val correctAnswer = arrayListOf(
                "12",
                "8",
                "29",
                "5",
                "3",
                "15",
                "74",
                "6",
                "45",
                "5",
                "7",
                "16",
                "73",
                "nothing",
                "nothing",
                "26",
                "42",
                "line_purple_and_line_red",
                "nothing",
                "line_blue_and_line_green",
                "line_orange",
                "line_blue_green_and_line_yellow_green",
                "line_purple_and_line_orange",
                "line_orange"
            )

            val optionOne = when (i) {
                14 -> "number_five"
                15 -> "number_five"
                18 -> "line_purple"
                19 -> "line_green"
                20 -> "line_blue_and_line_green"
                21 -> "line_orange"
                22 -> "line_blue_green_and_line_yellow_green"
                23 -> "nothing"
                24 -> "line_orange"
                else -> ""
            }

            val optionTwo = when (i) {
                14 -> "number_forty_five"
                15 -> "number_forty_five"
                18 -> "line_purple_and_line_red"
                19 -> "line_orange"
                20 -> "line_blue"
                21 -> "line_red"
                22 -> "nothing"
                23 -> "line_red"
                24 -> "line_red"
                else -> ""
            }

            val optionThree = when (i) {
                14 -> "nothing"
                15 -> "nothing"
                18 -> "line_red"
                19 -> "nothing"
                20 -> "nothing"
                21 -> "line_green"
                22 -> "line_blue_green_and_line_purple"
                23 -> "line_purple_and_line_orange"
                24 -> "line_purple"
                else -> ""
            }

            val question = QuestionData(
                id = i,
                image = "plate_24_$i",
                optionOne = optionOne,
                optionTwo = optionTwo,
                optionThree = optionThree,
                correctAnswer = correctAnswer[i - 1]
            )
            listQuestion.add(question)
        }

        return listQuestion
    }

    fun getAllQuestionThirtyEight(): ArrayList<QuestionData> {
        val listQuestion = ArrayList<QuestionData>()

        for (i in 1..38) {
            val correctAnswer = arrayListOf(
                "12",
                "8",
                "6",
                "29",
                "57",
                "5",
                "3",
                "15",
                "74",
                "2",
                "6",
                "97",
                "45",
                "5",
                "7",
                "16",
                "73",
                "nothing",
                "nothing",
                "nothing",
                "nothing",
                "26",
                "42",
                "35",
                "96",
                "line_purple_and_line_red",
                "line_purple_and_line_red",
                "nothing",
                "nothing",
                "line_blue_and_line_green",
                "line_blue_and_line_green",
                "line_orange",
                "line_orange",
                "line_blue_green_and_line_yellow_green",
                "line_blue_green_and_line_yellow_green",
                "line_purple_and_line_orange",
                "line_purple_and_line_orange",
                "line_orange"
            )

            val optionOne = when (i) {
                18 -> "number_five"
                19 -> "number_two"
                20 -> "number_forty_five"
                21 -> "number_seventy_three"
                26 -> "line_purple_and_line_red"
                27 -> "line_purple"
                28 -> "nothing"
                29 -> "line_orange"
                30 -> "line_blue"
                31 -> "line_green"
                32 -> "line_red"
                33 -> "line_red"
                34 -> "line_blue_green_and_line_purple"
                35 -> "line_blue_green_and_line_yellow_green"
                36 -> "nothing"
                37 -> "line_red"
                38 -> "line_orange"
                else -> ""
            }

            val optionTwo = when (i) {
                18 -> "number_forty_five"
                19 -> "number_six"
                20 -> "number_eight"
                21 -> "number_five"
                26 -> "nothing"
                27 -> "nothing"
                28 -> "line_orange"
                29 -> "line_green"
                30 -> "line_blue_and_line_green"
                31 -> "nothing"
                32 -> "line_orange"
                33 -> "line_green"
                34 -> "line_blue_green_and_line_yellow_green"
                35 -> "line_blue_green_and_line_purple"
                36 -> "line_blue_and_line_green"
                37 -> "nothing"
                38 -> "line_red"
                else -> ""
            }

            val optionThree = when (i) {
                18 -> "nothing"
                19 -> "nothing"
                20 -> "nothing"
                21 -> "nothing"
                26 -> "line_purple"
                27 -> "line_purple_and_line_red"
                28 -> "line_green"
                29 -> "nothing"
                30 -> "nothing"
                31 -> "line_blue_and_line_green"
                32 -> "line_green"
                33 -> "line_orange"
                34 -> "nothing"
                35 -> "nothing"
                36 -> "line_purple_and_line_orange"
                37 -> "line_purple_and_line_orange"
                38 -> "line_purple"
                else -> ""
            }
//            val optionFour = when(i) {
//                26 -> "nothing"
//                27 -> "line_purple_and_line_red"
//                28 -> "line_orange"
//                29 -> "line_green"
//                30 -> "nothing"
//                31 -> "line_blue_and_line_green"
//                34 -> "nothing"
//                35 -> "nothing"
//                36 -> "line_purple_and_line_orange"
//                37 -> "line_red"
//                else -> ""
//            }
            val question = QuestionData(
                id = i,
                image = "plate_38_$i",
                optionOne = optionOne,
                optionTwo = optionTwo,
                optionThree = optionThree,
                correctAnswer = correctAnswer[i - 1]
            )
            listQuestion.add(question)
        }

        return listQuestion
    }
}