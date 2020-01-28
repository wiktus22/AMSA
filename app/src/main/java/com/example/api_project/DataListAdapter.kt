package com.example.api_project

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_data.view.*
import kotlinx.android.synthetic.main.list_info.view.*

class DataListAdapter: RecyclerView.Adapter<DataListAdapter.ViewHolder>() {

    private var dataList = ArrayList<SensorData>()

    fun setData(list:ArrayList<SensorData>){
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
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        d("Lista", dataList[position].toString())
        val act = dataList[position]
        holder.dataKeyTextView.text=act.key
        holder.dataDateTextView.text= act.values?.date
        holder.dataValueTextView.text= act.values?.value.toString()


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