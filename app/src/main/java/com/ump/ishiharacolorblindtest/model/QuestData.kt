package com.ump.ishiharacolorblindtest.model

data class QuestData(
    var id: Int,
    var questionImage: String,
    var opt1: String,
    var opt2: String,
    var opt3: String,
    var correctAns: String
)
