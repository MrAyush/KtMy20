package com.example.ayushgupta.ktmy20

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.ahmadrosid.svgloader.SvgLoader
import com.example.ayushgupta.ktmy20.Model.IpDetails
import com.example.ayushgupta.ktmy20.ViewApi.ResultsApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ResultsApi {
    override fun onResultView(isSuccess: Boolean, dataList: MutableList<String>, imageURL: String) {
        if (isSuccess) {
            val imageView = findViewById<ImageView>(R.id.imageView)
            SvgLoader.pluck().with(this).load(imageURL, imageView)
            lview.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        } else
            Toast.makeText(this, "An error has occurred ", Toast.LENGTH_SHORT).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val ipString = if (editText.text.toString() == "") "8.8.8.8" else editText.text.toString()
            IpDetails(this).getDetails(ipString)
        }
        button1.setOnClickListener {
            IpDetails(this).getDetails("check")
        }
    }
}
