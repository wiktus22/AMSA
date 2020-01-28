package com.example.api_project

import com.google.gson.annotations.SerializedName

class Station {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("stationName")
    var stationName: String = ""

    @SerializedName("city")
    var city: City? = null

    override fun toString(): String {
        return id.toString() + ", " + city?.name + ", " + stationName + "\n"
    }

}

class City {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

}

class Sensor {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("param")
    var param: Parameters? = null

    /*override fun toString(): String {
        return id.toString() + ", " + param?.paramName + ", " + param?.paramCode + "\n"
    }*/

}


class Parameters {

    @SerializedName("paramName")
    var paramName: String = ""

    @SerializedName("paramCode")
    var paramCode: String = ""

}

class SensorData {

    @SerializedName("key")
    var key: String = ""

    @SerializedName("values")
    var values: SensorValue?=null
    //var values: List<SensorValue> = listOf<SensorValue>()

    /*override fun toString(): String {
        return key + ", " + values[0].toString() + ", " + values[1].toString()
    }*/

}

class SensorValue {

    @SerializedName("date")
    var date: String = ""


    @SerializedName("value")
    var value: Int? = null

    /*override fun toString(): String {
        return date// + " - " + value.toString()
    }*/

}