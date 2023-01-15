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
                "",
                "",
                "26",
                "42",
                "plate_24_18_option_1",
                "",
                "plate_24_20_option_3",
                "plate_24_21_option_2",
                "plate_24_22_option_1",
                "plate_24_23_option_1",
                "plate_24_24_option_1"
            )
            val optionOneName = "plate_24_${i}_option_1"
            val optionOne = when(i) {
                14 -> ""
                15 -> ""
                18 -> optionOneName
                19 -> ""
                20-> optionOneName
                21 -> optionOneName
                22 -> optionOneName
                23 -> optionOneName
                24 -> optionOneName
                else -> ""
            }
            val optionTwoName = "plate_24_${i}_option_2"
            val optionTwo = when(i) {
                14 -> ""
                15 -> ""
                18 -> optionTwoName
                19 -> ""
                20-> optionTwoName
                21 -> optionTwoName
                22 -> optionTwoName
                23 -> optionTwoName
                24 -> optionTwoName
                else -> ""
            }
            val optionThreeName = "plate_24_${i}_option_3"
            val optionThree = when(i) {
                14 -> ""
                15 -> ""
                18 -> optionThreeName
                19 -> ""
                20-> optionThreeName
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
                "",
                "",
                "",
                "",
                "26",
                "42",
                "35",
                "96",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            )
            val question = QuestionData(
                id = i,
                image = "plate_38_$i",
                optionOne = "",
                optionTwo = "",
                optionThree = "",
                correctAnswer = correctAnswer[i - 1]
            )
            listQuestion.add(question)
        }

        return listQuestion
    }
}