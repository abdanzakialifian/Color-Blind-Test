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
                "plate_14_9_option_3",
                "16",
                "plate_14_11_option_3",
                "35",
                "96",
                "plate_14_14_option_1"
            )
            val optionOneName = "plate_14_${i}_option_1"
            val optionOne = when(i) {
                9 -> optionOneName
                11 -> optionOneName
                14 -> optionOneName
                else -> ""
            }
            val optionTwoName = "plate_14_${i}_option_2"
            val optionTwo = when(i) {
                9 -> optionTwoName
                11 -> optionTwoName
                14 -> optionTwoName
                else -> ""
            }
            val optionThreeName = "plate_14_${i}_option_3"
            val optionThree = when(i) {
                9 -> optionThreeName
                11 -> optionThreeName
                14 -> optionThreeName
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
                "plate_14_9_option_3",
                "plate_14_9_option_3",
                "26",
                "42",
                "plate_24_18_option_1",
                "plate_14_9_option_3",
                "plate_24_20_option_3",
                "plate_24_21_option_2",
                "plate_24_22_option_1",
                "plate_24_23_option_1",
                "plate_24_24_option_1"
            )
            val optionOneName = "plate_24_${i}_option_1"
            val optionOne = when (i) {
                14 -> optionOneName
                15 -> optionOneName
                18 -> optionOneName
                19 -> optionOneName
                20 -> optionOneName
                21 -> optionOneName
                22 -> optionOneName
                23 -> optionOneName
                24 -> optionOneName
                else -> ""
            }
            val optionTwoName = "plate_24_${i}_option_2"
            val optionTwo = when (i) {
                14 -> optionTwoName
                15 -> optionTwoName
                18 -> optionTwoName
                19 -> optionTwoName
                20 -> optionTwoName
                21 -> optionTwoName
                22 -> optionTwoName
                23 -> optionTwoName
                24 -> optionTwoName
                else -> ""
            }
            val optionThreeName = "plate_24_${i}_option_3"
            val optionThree = when (i) {
                14 -> "plate_14_9_option_3"
                15 -> "plate_14_9_option_3"
                18 -> optionThreeName
                19 -> "plate_14_9_option_3"
                20 -> optionThreeName
                21 -> "plate_14_9_option_3"
                22 -> "plate_14_9_option_3"
                23 -> "plate_14_9_option_3"
                24 -> "plate_14_9_option_3"
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
                "plate_14_9_option_3",
                "plate_14_9_option_3",
                "plate_14_9_option_3",
                "plate_14_9_option_3",
                "26",
                "42",
                "35",
                "96",
                "plate_38_26_option_1",
                "plate_38_27_option_1",
                "plate_14_9_option_3",
                "plate_14_9_option_3",
                "plate_38_30_option_3",
                "plate_38_31_option_2",
                "plate_38_32_option_1",
                "plate_38_33_option_1",
                "plate_38_34_option_2",
                "plate_38_35_option_2",
                "plate_38_36_option_2",
                "plate_38_37_option_1",
                "plate_38_38_option_1"
            )
            val optionOneName = "plate_38_${i}_option_1"
            val optionOne = when (i) {
                18 -> optionOneName
                19 -> optionOneName
                20 -> optionOneName
                21 -> optionOneName
                26 -> optionOneName
                27 -> optionOneName
                28 -> optionOneName
                29 -> optionOneName
                30 -> optionOneName
                31 -> optionOneName
                32 -> optionOneName
                33 -> optionOneName
                34 -> optionOneName
                35 -> optionOneName
                36 -> optionOneName
                37 -> optionOneName
                38 -> optionOneName
                else -> ""
            }
            val optionTwoName = "plate_38_${i}_option_2"
            val optionTwo = when (i) {
                18 -> optionTwoName
                19 -> optionTwoName
                20 -> optionTwoName
                21 -> optionTwoName
                26 -> optionTwoName
                27 -> optionTwoName
                28 -> optionTwoName
                29 -> optionTwoName
                30 -> optionTwoName
                31 -> optionTwoName
                32 -> optionTwoName
                33 -> optionTwoName
                34 -> optionTwoName
                35 -> optionTwoName
                36 -> optionTwoName
                37 -> optionTwoName
                38 -> optionTwoName
                else -> ""
            }
            val optionThreeName = "plate_38_${i}_option_3"
            val optionThree = when (i) {
                18 -> "plate_14_9_option_3"
                19 -> "plate_14_9_option_3"
                20 -> "plate_14_9_option_3"
                21 -> "plate_14_9_option_3"
                26 -> optionThreeName
                27 -> optionThreeName
                28 -> "plate_14_9_option_3"
                29 -> "plate_14_9_option_3"
                30 -> optionThreeName
                31 -> optionThreeName
                32 -> "plate_14_9_option_3"
                33 -> "plate_14_9_option_3"
                34 -> "plate_14_9_option_3"
                35 -> "plate_14_9_option_3"
                36 -> "plate_14_9_option_3"
                37 -> "plate_14_9_option_3"
                38 -> "plate_14_9_option_3"
                else -> ""
            }
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