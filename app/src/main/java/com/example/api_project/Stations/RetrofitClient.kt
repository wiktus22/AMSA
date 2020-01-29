package com.example.api_project.Stations

import androidx.lifecycle.MutableLiveData
import com.example.api_project.RestAPI
import com.example.api_project.Station
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient : Callback<List<Station>> {

    companion object {
        val API_ADRESS = "http://api.gios.gov.pl/pjp-api/rest/"
    }

    var stationMutableList: MutableLiveData<List<Station>> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_ADRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restapi = retrofit.create(RestAPI::class.java)
        val kolejnazmienna = restapi.getStations()
        kolejnazmienna.enqueue(this)
    }


    override fun onFailure(call: Call<List<Station>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<List<Station>>?, response: Response<List<Station>>?) {
        if (response != null) {
            if (response.isSuccessful) {
                stationMutableList.value=response.body()
            }
        }
    }
}