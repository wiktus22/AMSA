package com.example.api_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var fragmentPlaces = PlacesFragment.newInstacne()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment.newInstacne()
        replaceFragment(fragment)
        refreshPlaces()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }


   private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.itemId

        if (id == R.id.add) {
            val fragment = MainFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }

        if (id==R.id.list) {
            val fragment = PlacesFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }

        if (id==R.id.home) {
            val fragment = InfoFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }

        if (id == R.id.hiden) {
            val fragment = DataSensorFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }




        return super.onOptionsItemSelected(item)

    }

    override fun onResume() {
        super.onResume()
        refreshPlaces()
    }

    fun refreshPlaces(){
        fragmentPlaces.refreshPlaces()
    }


    fun addStation(id:Int,stationName:String){

        val bundle=Bundle()
        bundle.putInt("id", id)
        bundle.putString("name",stationName)

        val fragment = AddFragment.newInstacne()
        fragment.setArguments(bundle)

        replaceFragment(fragment as Fragment)
    }
}
