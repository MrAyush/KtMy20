package com.example.ayushgupta.ktmy20.Beans

import com.google.gson.annotations.SerializedName

data class Language(
        @SerializedName("code") val code: String,
        @SerializedName("name") val name: String,
        @SerializedName("native") val native: String
)