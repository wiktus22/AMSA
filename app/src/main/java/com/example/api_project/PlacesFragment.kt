package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_places.*
import kotlinx.android.synthetic.main.list_places.*


class PlacesFragment: Fragment() {

    companion object{
        fun newInstacne() = PlacesFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_places,container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        places_list.layoutManager = LinearLayoutManager(view?.context, RecyclerView.VERTICAL, false)
    }


    override fun onResume() {
        super.onResume()
        refreshPlaces()
    }

    fun refreshPlaces() {

        if (view != null) {
            val dbHelper = DBHelper(view!!.context)
            places_list?.adapter = PlacesListAdapter(dbHelper.allItems, view!!.context)
        }

    }


}