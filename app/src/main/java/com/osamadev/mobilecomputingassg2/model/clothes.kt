package com.osamadev.mobilecomputingassg2.model

import java.io.Serializable

class clothes (var id:Int , var name:String , var desc:String , var price:Int , var img : Int) : Serializable {

    companion object {
        val COL_ID = "id"
        val COL_NAME = "name"
        val COL_DESC = "desc"
        val COL_PRICE = "price"
        val COL_IMG = "img"

        val TABLE_NAME = "Clothes"
        val TABLE_CREATE = "create table $TABLE_NAME ($COL_ID integer primary key autoincrement ," +
                "$COL_NAME text not null  , " +
                "$COL_DESC text not null , " +
                "$COL_PRICE integer , " +
                "$COL_IMG integer ) ;"

    }
}