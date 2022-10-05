package com.example.kariscore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class CreateWork(
    @Expose
    @SerializedName("score_name")
    val score_name: String,

    @Expose
    @SerializedName("score_date")
    val score_date: LocalDate,

    @Expose
    @SerializedName("full_score")
    val full_score: Int,

    @Expose
    @SerializedName("subject_id")
    val subject_id: Int
)
{}