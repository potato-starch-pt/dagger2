package com.example.catfacts.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FactDto(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)