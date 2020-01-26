package com.example.api_project


import retrofit2.Call
import retrofit2.http.GET




interface RestAPI {


    @GET("findAll")
    fun getStations(): Call<List<Test>>

    /*@GET("station/sensors/{stationid}")
    fun sensorsInStation(@Path("stationid") stationId: Int): Call<List<Sensor>>

    @GET("data/getData/{sensorId}")
    fun sensorData(@Path("sensorId") sensorId: Int): Call<SensorData>*/


}