package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_places.*


class PlacesFragment: Fragment() {

    companion object{
        fun newInstacne() = PlacesFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_places,container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {

        UpdateData()
        super.onActivityCreated(savedInstanceState)


    }

    fun UpdateData(){
        val dbHelper = DBHelper(context as MainActivity)
        places_list.layoutManager= LinearLayoutManager(context as MainActivity, RecyclerView.VERTICAL,false)
        places_list.adapter=PlacesListAdapter(dbHelper.allItems,context as MainActivity)

    }


}