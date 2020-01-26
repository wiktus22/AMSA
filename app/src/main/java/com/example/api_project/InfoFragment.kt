package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer

class InfoFragment: Fragment() {

    companion object{
        fun newInstacne() = InfoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info,container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var rest= RetrofitClientSensors()
        var recyclerView = view!!.findViewById<RecyclerView>(R.id.RecViewInfo)
        var adapter = SensorsListAdapter()
        rest.sensorsMutableList.observe(this, Observer { adapter.setSensor(ArrayList(it)) })
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(context)


    }
}