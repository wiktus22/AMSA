package com.example.api_project.SensorsData

import androidx.lifecycle.MutableLiveData
import com.example.api_project.RestAPI
import com.example.api_project.SensorData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientData(val id:Int): Callback<SensorData> {

    companion object {
        val API_ADRESS = "http://api.gios.gov.pl/pjp-api/rest/"
    }

    var dataMutable: MutableLiveData<SensorData> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_ADRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restapi = retrofit.create(RestAPI::class.java)
        val dane = restapi.sensorData(id!!)
        dane.enqueue(this)
    }



    override fun onFailure(call: Call<SensorData>, t: Throwable?) {
       // Log.d("qaz",t.toString())
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<SensorData>, response: Response<SensorData>) {
        if (response != null) {
            if (response.isSuccessful) {
                //Log.d("qaz",response.body().toString())
                dataMutable.value=response.body()

            }
        }
    }
}