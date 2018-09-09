package com.example.ayushgupta.ktmy20.Model

import android.app.Activity
import android.util.Log
import com.example.ayushgupta.ktmy20.Beans.IpBeans
import com.example.ayushgupta.ktmy20.MainActivity
import com.example.ayushgupta.ktmy20.Presenter.IpApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IpDetails(val activity: Activity) {
    lateinit var retrofit: Retrofit
    lateinit var list: MutableList<String>

    fun getDetails(ipString: String) {
        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.ipstack.com/").build()
        val ipApi = retrofit.create(IpApi::class.java)
        val call = ipApi.getIpDetails(ipString)
        list = mutableListOf()
        call.enqueue(object : Callback<IpBeans> {
            override fun onFailure(call: Call<IpBeans>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<IpBeans>, response: Response<IpBeans>) {
                Log.w("Inside @IpDetails", "${response.body()}")
                val ipDets = response.body()
                list.add("Ip: " + ipDets?.ip.toString())
                list.add("Connection type: " + ipDets?.type.toString())
                list.add("Country: ${ipDets?.countryName.toString()}, ${ipDets?.countryCode.toString()}")
                list.add("Continent: " + ipDets?.continentName.toString())
                list.add("Region: " + ipDets?.regionName.toString())
                list.add("City: ${ipDets?.city.toString()}, ${ipDets?.zip.toString()}")
                list.add("Location: ${ipDets?.latitude.toString()}, ${ipDets?.longitude.toString()}")
                var lan = "Languages: "
                for (lang in ipDets?.location?.languages!!) {
                    lan += ("\tCode - ${lang.code}\n\tName - ${lang.name}\n\tNative - ${lang.native}")
                }
                list.add(lan)
                list.add("County emoticon: ${ipDets.location.countryFlagEmoji}")
                list.add("Calling code: +${ipDets.location.callingCode}")
                (activity as MainActivity).onResultView(response.isSuccessful, list, ipDets.location.countryFlag)
            }
        })
    }
}