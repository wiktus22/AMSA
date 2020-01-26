
package com.example.api_project

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClientSensors: Callback<List<Sensor>> {

    companion object {
        val API_ADRESS = "http://api.gios.gov.pl/pjp-api/rest/"
    }

    var sensorsMutableList: MutableLiveData<List<Sensor>> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_ADRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restapi = retrofit.create(RestAPI::class.java)
        val kolejnazmienna = restapi.sensorsInStation(809)
        kolejnazmienna.enqueue(this)
    }


    override fun onFailure(call: Call<List<Sensor>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<List<Sensor>>?, response: Response<List<Sensor>>?) {
        if (response != null) {
            if (response.isSuccessful) {
                sensorsMutableList.value=response.body()
            }
        }
    }
}