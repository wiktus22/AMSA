package com.example.api_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.api_project.Sensors.InfoFragment
import com.example.api_project.SensorsData.DataSensorFragment
import com.example.api_project.Stations.MainFragment
import com.example.api_project.UserPlaces.PlacesFragment

class MainActivity : AppCompatActivity() {

    var fragmentPlaces = PlacesFragment.newInstacne()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = WelcomeFragment.newInstacne()
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

        /*if (id==R.id.delete) {
            val fragment = DeleteFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }*/


        if (id==R.id.home) {
            val fragment = PlacesFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }

        if (id == R.id.hiden) {
            val fragment = AboutFragment.newInstacne()
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

    fun addSensors(id:Int){
        val bundle=Bundle()
        bundle.putInt("id",id)
        val fragment = InfoFragment.newInstacne()
        fragment.setArguments(bundle)

        replaceFragment(fragment as Fragment)
    }

    fun addSensorsData(id:Int){
        val bundle=Bundle()
        bundle.putInt("id",id)
        val fragment = DataSensorFragment.newInstacne()
        fragment.setArguments(bundle)

        replaceFragment(fragment as Fragment)
    }

    
}
