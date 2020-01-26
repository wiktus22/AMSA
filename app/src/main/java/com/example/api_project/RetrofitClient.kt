package com.example.api_project

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class RetrofitClient {

    companion object{
        val API_ADRESS="http://api.gios.gov.pl/pjp-api/rest/"
    }

    fun getService():RestAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl(API_ADRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RestAPI::class.java)
    }
}