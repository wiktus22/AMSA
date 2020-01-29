package com.example.api_project.Stations


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import com.example.api_project.R

class MainFragment: Fragment() {

    companion object{
        fun newInstacne() = MainFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var rest= RetrofitClient()
        var recyclerView = view!!.findViewById<RecyclerView>(R.id.RecViewLayout)
        var adapter = StationsListAdapter()
        rest.stationMutableList.observe(this, Observer { adapter.setStation(ArrayList(it)) })
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }



}