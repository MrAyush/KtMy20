package com.example.ayushgupta.ktmy20.Beans

import com.google.gson.annotations.SerializedName

data class IpBeans(
        @SerializedName("ip") val ip: String,
        @SerializedName("type") val type: String,
        @SerializedName("continent_code") val continentCode: String,
        @SerializedName("continent_name") val continentName: String,
        @SerializedName("country_code") val countryCode: String,
        @SerializedName("country_name") val countryName: String,
        @SerializedName("region_code") val regionCode: Any,
        @SerializedName("region_name") val regionName: Any,
        @SerializedName("city") val city: Any,
        @SerializedName("zip") val zip: Any,
        @SerializedName("latitude") val latitude: Double,
        @SerializedName("longitude") val longitude: Double,
        @SerializedName("location") val location: Location
)