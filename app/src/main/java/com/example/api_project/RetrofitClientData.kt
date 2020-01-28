package com.example.api_project

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientData: Callback<List<SensorData>> {

    companion object {
        val API_ADRESS = "http://api.gios.gov.pl/pjp-api/rest/"
    }

    var dataMutableList: MutableLiveData<List<SensorData>> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_ADRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restapi = retrofit.create(RestAPI::class.java)
        val dane = restapi.sensorData(92)
        dane.enqueue(this)
    }



    override fun onFailure(call: Call<List<SensorData>>, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<List<SensorData>>, response: Response<List<SensorData>>) {
        if (response != null) {
            if (response.isSuccessful) {

                dataMutableList.value=response.body()
            }
        }
    }
}