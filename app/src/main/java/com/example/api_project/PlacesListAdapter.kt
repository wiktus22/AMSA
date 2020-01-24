package com.example.api_project

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PlacesListAdapter(val places:MutableList<Place>,val context: Context) : RecyclerView.Adapter<PlacesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder{
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_places,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var place=places[position]

        holder.placeName.text=place.name
        holder.placeButton.setOnClickListener() {
            val intent= Intent(context,PlacesFragment.newInstacne()::class.java).apply {
                putExtra("ItemID",places[position].id)
            }
            context.startActivity(intent)
        }

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val placeName=itemView.findViewById<TextView>(R.id.place_name)
        val placeButton=itemView.findViewById<Button>(R.id.place_del_button)

    }
}