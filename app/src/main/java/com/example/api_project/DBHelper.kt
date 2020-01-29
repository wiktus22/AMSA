package com.example.api_project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.api_project.UserPlaces.Place

class DBHelper(context: Context): SQLiteOpenHelper(context, DATA_BASE_NAME,null, DATA_BASE_VERSION) {

    companion object{

        internal  const val DATA_BASE_NAME="places.db"
        internal const val DATA_BASE_VERSION=1
        internal const val TABLE_NAME="places"
        internal const val COL_ID="id"
        internal const val COL_NAME="name"
    }

    override fun onCreate(db: SQLiteDatabase?){
        val sql=db!!.execSQL(
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME("+
                    "$COL_ID INTEGER PRIMARY KEY,"+
                    "$COL_NAME TEXT NOT NULL)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val allItems: MutableList<Place>
        get(){
            val query="SELECT * FROM $TABLE_NAME"
            val places= mutableListOf<Place>()
            val db=this.writableDatabase
            val cursor=db.rawQuery(query,null)

            if(cursor.moveToFirst()){
                do{
                    val id=cursor.getInt(cursor.getColumnIndex(COL_ID))
                    val name=cursor.getString(cursor.getColumnIndex(COL_NAME))

                    var place= Place(name, id)
                    place.id = id
                    places.add(place)


                }while(cursor.moveToNext())
            }
            db.close()
            return places
        }

    fun addItem(place: Place){

        val db=this.writableDatabase
        val value= contentValuesOf()
        value.put(COL_ID,place.id)
        value.put(COL_NAME,place.name)
        db.insert(TABLE_NAME,null,value)
        db.close()
        return
    }

    fun deletePlace(id: Int?) {
        this.writableDatabase.execSQL("DELETE FROM $TABLE_NAME WHERE $COL_ID LIKE $id")
    }
}