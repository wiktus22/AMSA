package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api_project.UserPlaces.Place
import com.example.api_project.UserPlaces.PlacesFragment
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment:Fragment() {

    companion object {
        fun newInstacne() = WelcomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getStartedButton.setOnClickListener {
            (it.context as MainActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, PlacesFragment.newInstacne())
                .commit()

            //Toast.makeText(context as MainActivity,"Place Added", Toast.LENGTH_LONG).show()

        }
    }
}