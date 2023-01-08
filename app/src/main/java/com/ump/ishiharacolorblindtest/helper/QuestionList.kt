package com.ump.ishiharacolorblindtest.helper

import com.ump.ishiharacolorblindtest.model.QuestData

object QuestionList {
    fun getAllQuestionPlateFourteen(): ArrayList<QuestData> {
        val listQuest: ArrayList<QuestData> = arrayListOf()

        val questionOne = QuestData(
            1,
            "number_twelve",
            "",
            "",
            "",
            "12"
        )
        listQuest.add(questionOne)

        val questionTwo = QuestData(
            2,
            "number_eight",
            "",
            "",
            "",
            "8"
        )
        listQuest.add(questionTwo)

        val questionThree = QuestData(
            3,
            "number_five",
            "",
            "",
            "",
            "5"
        )
        listQuest.add(questionThree)

        val questionFour = QuestData(
            4,
            "number_twenty_nine",
            "",
            "",
            "",
            "29"
        )
        listQuest.add(questionFour)

        val questionFive = QuestData(
            5,
            "number_seventy_four",
            "",
            "",
            "",
            "74"
        )
        listQuest.add(questionFive)

        val questionSix = QuestData(
            6,
            "number_seven",
            "",
            "",
            "",
            "7"
        )
        listQuest.add(questionSix)

        val questionSeven = QuestData(
            7,
            "number_forty_five",
            "",
            "",
            "",
            "45"
        )
        listQuest.add(questionSeven)

        val questionEight = QuestData(
            8,
            "number_two",
            "",
            "",
            "",
            "2"
        )
        listQuest.add(questionEight)

        val questionNine = QuestData(
            9,
            "option_one",
            "option_one_1",
            "option_one_2",
            "option_one_3",
            "option_one_3"
        )
        listQuest.add(questionNine)

        val questionTen = QuestData(
            10,
            "number_sixteen",
            "",
            "",
            "",
            "16"
        )
        listQuest.add(questionTen)

        val questionEleven = QuestData(
            11,
            "option_two",
            "option_two_1",
            "option_two_2",
            "option_two_3",
            "option_two_3"
        )
        listQuest.add(questionEleven)

        val questionTwelve = QuestData(
            12,
            "number_thirty_five",
            "",
            "",
            "",
            "35"
        )
        listQuest.add(questionTwelve)

        val questionThirteen = QuestData(
            13,
            "number_ninety_six",
            "",
            "",
            "",
            "96"
        )
        listQuest.add(questionThirteen)

        val questionFourteen = QuestData(
            14,
            "option_three",
            "option_three_1",
            "option_three_2",
            "option_three_3",
            "option_three_1"
        )
        listQuest.add(questionFourteen)

        return listQuest
    }
}