package com.ump.ishiharacolorblindtest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SavedAnswerData(
    val questionNumber: String,
    val question: String,
    val answer: String,
    val correctAns: String
) : Parcelable
