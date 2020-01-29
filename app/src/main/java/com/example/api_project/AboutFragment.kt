package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api_project.UserPlaces.Place
import com.example.api_project.UserPlaces.PlacesFragment
import kotlinx.android.synthetic.main.fragment_add.*

class AboutFragment:Fragment() {
    companion object {
        fun newInstacne() = AboutFragment()
    }

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)

    }

}