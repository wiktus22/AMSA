package com.example.api_project

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_places.view.*


class PlacesListAdapter(val places:MutableList<Place>,val context: Context) : RecyclerView.Adapter<PlacesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder{
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_places,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val place=places[position]

        holder.placeName.text=place.name


        val view = holder?.itemView

        view?.setOnClickListener {
            Toast.makeText(context as MainActivity,places[position].id.toString(),Toast.LENGTH_LONG).show()

        }

        view?.place_del_button?.setOnClickListener {

            val dbHelper = DBHelper(context)
            dbHelper.deletePlace(places[position].id)

            (context as MainActivity).refreshPlaces()

            (it.context as MainActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, PlacesFragment.newInstacne())
                .commit()

        }

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val placeName=itemView.findViewById<TextView>(R.id.place_name)


    }

}