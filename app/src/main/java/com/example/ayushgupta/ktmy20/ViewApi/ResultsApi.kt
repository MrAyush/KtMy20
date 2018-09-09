package com.example.ayushgupta.ktmy20.ViewApi

interface ResultsApi {
    fun onResultView(isSuccess: Boolean, dataList: MutableList<String>, imageURL: String)
}