package com.example.ayushgupta.ktmy20.Presenter

import com.example.ayushgupta.ktmy20.Beans.IpBeans
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IpApi {
    @GET("{ipStr}?access_key=YOUR_API_KEY")
    fun getIpDetails(@Path("ipStr") ipStr:String): Call<IpBeans>
}