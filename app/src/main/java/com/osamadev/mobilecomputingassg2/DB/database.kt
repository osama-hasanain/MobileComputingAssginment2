package com.osamadev.mobilecomputingassg2.DB

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.osamadev.mobilecomputingassg2.model.clothes
import com.osamadev.mobilecomputingassg2.model.electronic
import com.osamadev.mobilecomputingassg2.model.food

class database(var context:Activity) : SQLiteOpenHelper(context, DB_NAME,null , DB_VERSION) {

    companion object {
        public val DB_NAME: String = "Details"
        public val DB_VERSION: Int = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
       db!!.execSQL(food.TABLE_CREATE)
       db!!.execSQL(electronic.TABLE_CREATE)
       db!!.execSQL(clothes.TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("Drop table if exists ${food.TABLE_NAME}")
        db!!.execSQL("Drop table if exists ${electronic.TABLE_NAME}")
        db!!.execSQL("Drop table if exists ${clothes.TABLE_NAME}")
    }

    fun insertFood(f: food): Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val cv = ContentValues()
        cv.put(food.COL_NAME,f.name)
        cv.put(food.COL_DESC,f.desc)
        cv.put(food.COL_PRICE,f.price)
        cv.put(food.COL_IMG,f.img)
        return db.insert(food.TABLE_NAME,null,cv) > 0
    }

    fun getAllFood(): ArrayList<food> {
        val db: SQLiteDatabase = this.writableDatabase
        val data = ArrayList<food>()
        val c =
            db.rawQuery("select * from ${food.TABLE_NAME} order by ${food.COL_ID} desc", null)
        c.moveToFirst()
        while (!c.isAfterLast) {
            val f = food(c.getInt(0), c.getString(1), c.getString(2),c.getInt(3), c.getInt(4))
            data.add(f)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun insertClothe(c: clothes): Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val cv = ContentValues()
        cv.put(clothes.COL_NAME,c.name)
        cv.put(clothes.COL_DESC,c.desc)
        cv.put(clothes.COL_PRICE,c.price)
        cv.put(clothes.COL_IMG,c.img)
        return db.insert(clothes.TABLE_NAME,null,cv) > 0
    }

    fun getAllClothes(): ArrayList<clothes> {
        val db: SQLiteDatabase = this.writableDatabase
        val data = ArrayList<clothes>()
        val c =
            db.rawQuery("select * from ${clothes.TABLE_NAME} order by ${clothes.COL_ID} desc", null)
        c.moveToFirst()
        while (!c.isAfterLast) {
            val f = clothes(c.getInt(0), c.getString(1), c.getString(2),c.getInt(3), c.getInt(4))
            data.add(f)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun insertElectronic(c: electronic): Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val cv = ContentValues()
        cv.put(electronic.COL_NAME,c.name)
        cv.put(electronic.COL_DESC,c.desc)
        cv.put(electronic.COL_PRICE,c.price)
        cv.put(electronic.COL_IMG,c.img)
        return db.insert(electronic.TABLE_NAME,null,cv) > 0
    }

    fun getAllElectronic(): ArrayList<electronic> {
        val db: SQLiteDatabase = this.writableDatabase
        val data = ArrayList<electronic>()
        val c =
            db.rawQuery("select * from ${electronic.TABLE_NAME} order by ${electronic.COL_ID} desc", null)
        c.moveToFirst()
        while (!c.isAfterLast) {
            val f = electronic(c.getInt(0), c.getString(1), c.getString(2),c.getInt(3), c.getInt(4))
            data.add(f)
            c.moveToNext()
        }
        c.close()
        return data
    }

}