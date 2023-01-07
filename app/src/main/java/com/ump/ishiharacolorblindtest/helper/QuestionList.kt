package com.ump.ishiharacolorblindtest.helper

import com.ump.ishiharacolorblindtest.model.QuestData

object QuestionList {
    fun getAllQuestion(): ArrayList<QuestData> {
        val quest: ArrayList<QuestData> = arrayListOf()

        val q1 = QuestData(
            1,
            "angka_12",
            "12",
            "13",
            "11",
            "12"
        )
        quest.add(q1)

        val q2 = QuestData(
            2,
            "angka_8",
            "9",
            "6",
            "8",
            "8"
        )
        quest.add(q2)

        val q3 = QuestData(
            3,
            "angka_5",
            "6",
            "5",
            "8",
            "5"
        )
        quest.add(q3)

        val q4 = QuestData(
            4,
            "angka_29",
            "28",
            "29",
            "79",
            "29"
        )
        quest.add(q4)

        val q5 = QuestData(
            5,
            "angka_74",
            "74",
            "24",
            "71",
            "74"
        )
        quest.add(q5)

        val q6 = QuestData(
            6,
            "angka_7",
            "1",
            "2",
            "7",
            "7"
        )
        quest.add(q6)

        val q7 = QuestData(
            7,
            "angka_45",
            "46",
            "48",
            "45",
            "45"
        )
        quest.add(q7)

        val q8 = QuestData(
            8,
            "angka_2",
            "5",
            "7",
            "2",
            "2"
        )
        quest.add(q8)

        // image 9
        val q9 = QuestData(
            9,
            "garis3",
            "garis3_1",
            "garis3_2",
            "garis3_3",
            "garis3_3"
        )
        quest.add(q9)
        // ./image 9

        val q10 = QuestData(
            10,
            "angka_16",
            "18",
            "16",
            "76",
            "16"
        )
        quest.add(q10)

        // image 11
        val q11 = QuestData(
            11,
            "garis2",
            "garis2_1",
            "garis2_2",
            "garis2_3",
            "garis2_3"
        )
        quest.add(q11)
        // /.image 11

        val q12 = QuestData(
            12,
            "angka_35",
            "35",
            "36",
            "85",
            "35"
        )
        quest.add(q12)

        val q13 = QuestData(
            13,
            "angka_96",
            "95",
            "85",
            "96",
            "96"
        )
        quest.add(q13)

        // image 14
        val q14 = QuestData(
            14,
            "garis4",
            "garis4_1",
            "garis4_2",
            "garis4_3",
            "garis4_1"
        )
        quest.add(q14)
        // /.image 14

        return quest
    }
}