package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment:Fragment() {

    companion object{
        fun newInstacne() = AddFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add,container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        val dbHelper = DBHelper(context as MainActivity)

        place_add_done.setOnClickListener {

            val place = Place(place_add_name.text.toString())
            dbHelper.addItem(place)

            //Toast.makeText(context as MainActivity,"Place Added", Toast.LENGTH_LONG).show()

        }
        super.onActivityCreated(savedInstanceState)
    }
}