package com.example.kariscore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ScoreStudent (
    @Expose
    @SerializedName("score_id")
    val score_id:Int,

    @Expose
    @SerializedName("user_id")
    val user_id:Int,

    @Expose
    @SerializedName("score")
    val score:Double

    )
{}