package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_data_sensor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataSensorFragment:Fragment() {

    companion object{
        fun newInstacne() = DataSensorFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_data_sensor,container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var rest= RetrofitClientData()
        var recyclerView = view!!.findViewById<RecyclerView>(R.id.RecViewData)
        var adapter = DataListAdapter()
        rest.dataMutableList.observe(this, Observer { adapter.setData(ArrayList(it)) })
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        

    }
}