package com.ump.ishiharacolorblindtest.model

data class HistoryListData(
    val id: Int,
    val questionType: String,
    val questionTotal: Int,
    val correctTotal: Int,
    val wrongTotal: Int,
    val scoreTotal: Int
)
