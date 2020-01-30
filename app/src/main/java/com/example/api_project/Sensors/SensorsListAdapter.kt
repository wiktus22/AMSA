package com.example.api_project.Sensors

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_project.MainActivity
import com.example.api_project.R
import com.example.api_project.Sensor
import com.example.api_project.UserPlaces.PlacesFragment
import kotlinx.android.synthetic.main.fragment_info.view.*
import kotlinx.android.synthetic.main.list_info.view.*

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
        val view = holder?.itemView
        holder.sensorIDTextView.text=act.id.toString()
        holder.sensorNameTextView.text= act.param?.paramName
        holder.sensorCodeTextView.text= act.param?.paramCode

        view?.setOnClickListener {
            (it.context as MainActivity).addSensorsData(act.id!!)

        }


        if (position%2 != 0) {
            holder.sensorIDTextView.setBackgroundColor(Color.LTGRAY)
            holder.sensorNameTextView.setBackgroundColor(Color.LTGRAY)
            holder.sensorCodeTextView.setBackgroundColor(Color.LTGRAY)
        }

    }
}