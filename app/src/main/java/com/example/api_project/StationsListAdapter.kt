package com.example.api_project

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.list_stations.view.*

class StationsListAdapter: RecyclerView.Adapter<StationsListAdapter.ViewHolder>() {

    private var listInAdapter = ArrayList<Test>()

    fun setStation(list:ArrayList<Test>){
        listInAdapter=list
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
        return listInAdapter.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val act = listInAdapter[position]
        holder.stationIDTextView.text=act.id.toString()
        holder.stationNameTextView.text=act.stationName

       /* if (position%2 != 0) {
            holder.stationIDTextView.setBackgroundColor(Color.BLUE)
            holder.stationNameTextView.setBackgroundColor(Color.BLUE)
        }
        else{
            holder.stationIDTextView.setBackgroundColor(Color.GREEN)
            holder.stationNameTextView.setBackgroundColor(Color.GREEN)
        }*/
        /*holder.itemView.setOnClickListener{
            (it.context as MainActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.tester,FragmentCurrentStationInfo())
                .commit()



        }*/

    }
}