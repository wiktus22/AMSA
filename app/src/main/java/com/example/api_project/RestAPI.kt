package com.example.api_project

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Path


interface RestAPI {


    @GET("station/findAll")
    fun allSensors(): Call<List<Station>>

    @GET("station/sensors/{stationid}")
    fun sensorsInStation(@Path("stationid") stationId: Int): Call<List<Sensor>>

    @GET("data/getData/{sensorId}")
    fun sensorData(@Path("sensorId") sensorId: Int): Call<SensorData>


}