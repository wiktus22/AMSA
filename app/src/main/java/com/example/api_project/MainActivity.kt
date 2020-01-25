package com.example.api_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    var fragmentPlaces = PlacesFragment.newInstacne()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment.newInstacne()
        replaceFragment(fragment)
        refreshPlaaces()
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
            val fragment = AddFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }


        if (id == R.id.hiden) {
            Toast.makeText(this, "Item Hiden Clicked", Toast.LENGTH_LONG).show()
            return true
        }

        if (id==R.id.list) {
            val fragment = PlacesFragment.newInstacne()
            replaceFragment(fragment)
            return true
        }


        return super.onOptionsItemSelected(item)

    }

    override fun onResume() {
        super.onResume()
        refreshPlaaces()
    }

    fun refreshPlaaces(){
        fragmentPlaces.refreshPlaces()
    }

}
