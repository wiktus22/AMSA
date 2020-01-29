package com.example.api_project.SensorsData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_project.R

class DataSensorFragment:Fragment() {

    companion object{
        fun newInstacne() =
            DataSensorFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_data_sensor,container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = arguments?.getInt("id")
        var rest= RetrofitClientData(id!!)
        var recyclerView = view!!.findViewById<RecyclerView>(R.id.RecViewData)
        var adapter = DataListAdapter()
        rest.dataMutable.observe(this, Observer { adapter.setData(it) })
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(context)


    }

}