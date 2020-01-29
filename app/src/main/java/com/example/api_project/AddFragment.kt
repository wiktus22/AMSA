package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api_project.UserPlaces.Place
import com.example.api_project.UserPlaces.PlacesFragment
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment:Fragment() {

    companion object {
        fun newInstacne() = AddFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        val id = arguments?.getInt("id")
        val name = arguments?.getString("name")
        val dbHelper = DBHelper(context as MainActivity)
        //Toast.makeText(context as MainActivity,name, Toast.LENGTH_LONG).show()

        textViewId.text=id.toString()
        textViewName.text=name

        place_add_done.setOnClickListener {
            val place = Place(name, id)
            dbHelper.addItem(place)
            (it.context as MainActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, PlacesFragment.newInstacne())
                .commit()

            //Toast.makeText(context as MainActivity,"Place Added", Toast.LENGTH_LONG).show()

        }
        super.onActivityCreated(savedInstanceState)
    }
}