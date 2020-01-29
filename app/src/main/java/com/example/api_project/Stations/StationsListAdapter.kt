package com.example.api_project.Stations

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_project.MainActivity
import com.example.api_project.R
import com.example.api_project.Station

import kotlinx.android.synthetic.main.list_stations.view.*
import kotlin.collections.ArrayList

class StationsListAdapter: RecyclerView.Adapter<StationsListAdapter.ViewHolder>() {

    private var stationsList = ArrayList<Station>()

    fun setStation(list:ArrayList<Station>){
        stationsList=list
        notifyDataSetChanged()
    }



    inner class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val stationIDTextView = view.Station_id!!
        val stationNameTextView = view.Station_name!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_stations,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stationsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val act = stationsList[position]
        holder.stationIDTextView.text=act.id.toString()
        holder.stationNameTextView.text=act.stationName

       /* if (position%2 != 0) {
            holder.stationIDTextView.setBackgroundColor(Color.LTGRAY)
            holder.stationNameTextView.setBackgroundColor(Color.LTGRAY)
        }*/



        holder.itemView.setOnClickListener{
            //Toast.makeText(it.context as MainActivity,act.id.toString(), Toast.LENGTH_LONG).show()
            (it.context as? MainActivity)?.addStation(act.id,act.stationName)

        }

    }
}