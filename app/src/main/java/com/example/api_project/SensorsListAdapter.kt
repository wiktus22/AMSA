package com.example.api_project

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_info.view.*

import kotlinx.android.synthetic.main.list_stations.view.*

class SensorsListAdapter: RecyclerView.Adapter<SensorsListAdapter.ViewHolder>() {

    private var sensorsList = ArrayList<Sensor>()

    fun setSensor(list:ArrayList<Sensor>){
        sensorsList=list
        notifyDataSetChanged()
    }



    inner class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val sensorIDTextView = view.sensorId!!
        val sensorNameTextView = view.sensorParamName!!
        val sensorCodeTextView = view.sensorParamCode!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_info,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sensorsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val act = sensorsList[position]
        holder.sensorIDTextView.text=act.id.toString()
        holder.sensorNameTextView.text= act.param?.paramName
        holder.sensorCodeTextView.text= act.param?.paramCode


       /* if (position%2 != 0) {
            holder.stationIDTextView.setBackgroundColor(Color.GRAY)
            holder.stationNameTextView.setBackgroundColor(Color.GRAY)
        }
        else{
            holder.stationIDTextView.setBackgroundColor(Color.GREEN)
            holder.stationNameTextView.setBackgroundColor(Color.GREEN)
        }


        holder.itemView.setOnClickListener{
            //Toast.makeText(it.context as MainActivity,act.id.toString(), Toast.LENGTH_LONG).show()
            (it.context as? MainActivity)?.addStation(act.id,act.stationName)

        }*/

    }
}