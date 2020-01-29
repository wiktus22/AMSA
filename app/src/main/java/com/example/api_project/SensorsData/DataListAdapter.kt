package com.example.api_project.SensorsData

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_project.MainActivity
import com.example.api_project.R
import com.example.api_project.SensorData
import kotlinx.android.synthetic.main.list_data.view.*

class DataListAdapter: RecyclerView.Adapter<DataListAdapter.ViewHolder>() {

    private var dataList: SensorData =
        SensorData()

    fun setData(list: SensorData){
        dataList=list
        notifyDataSetChanged()
    }



    inner class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val dataKeyTextView = view.dataKey!!
        val dataDateTextView = view.dataDate!!
        val dataValueTextView = view.dataValue!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_data,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.values.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //d("Lista", dataList.values[position].toString())
        val act = dataList.values[position]
        holder.dataKeyTextView.text=dataList.key
        holder.dataDateTextView.text= act.date
        holder.dataValueTextView.text= act.value.toString()


        /*if (position%2 != 0) {
             holder.dataKeyTextView.setBackgroundColor(Color.LTGRAY)
             holder.dataDateTextView.setBackgroundColor(Color.LTGRAY)
             holder.dataValueTextView.setBackgroundColor(Color.LTGRAY)
         }*/



    }
}