package com.example.api_project

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient : Callback<List<Test>> {

    /*companion object {
        val API_ADRESS = "http://api.gios.gov.pl/pjp-api/rest/"
    }

    fun getService(): RestAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_ADRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RestAPI::class.java)
    }*/
    var stationMutableList: MutableLiveData<List<Test>> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.gios.gov.pl/pjp-api/rest/station/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restapi = retrofit.create(RestAPI::class.java)
        val kolejnazmienna = restapi.getStations()
        kolejnazmienna.enqueue(this)
    }

    override fun onFailure(call: Call<List<Test>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<List<Test>>?, response: Response<List<Test>>?) {
        if (response != null) {
            if (response.isSuccessful) {
                stationMutableList.value=response.body()
            }
        }
    }
}