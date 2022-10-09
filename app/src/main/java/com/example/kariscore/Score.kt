package com.example.kariscore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Score (
    @Expose
    @SerializedName("score_id")
    val score_id:Int,

    @Expose
    @SerializedName("score_name")
    val score_name:String,

    @Expose
    @SerializedName("score_date")
    val score_date:String

    )

{}

