package com.example.ayushgupta.ktmy20.Beans

import com.google.gson.annotations.SerializedName

data class Location(
        @SerializedName("geoname_id") val geonameId: Any,
        @SerializedName("capital") val capital: String,
        @SerializedName("languages") val languages: List<Language>,
        @SerializedName("country_flag") val countryFlag: String,
        @SerializedName("country_flag_emoji") val countryFlagEmoji: String,
        @SerializedName("country_flag_emoji_unicode") val countryFlagEmojiUnicode: String,
        @SerializedName("calling_code") val callingCode: String,
        @SerializedName("is_eu") val isEu: Boolean
)