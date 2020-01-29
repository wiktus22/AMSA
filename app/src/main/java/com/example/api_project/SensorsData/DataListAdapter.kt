package com.example.api_project.SensorsData

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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