package com.ump.ishiharacolorblindtest.model

data class QuestionData(
    var id: Int,
    var image: String,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String = "",
    var correctAnswer: String
)
