package com.osamadev.mobilecomputingassg2.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.osamadev.mobilecomputingassg2.Adapter.clothesAdapter
import com.osamadev.mobilecomputingassg2.Adapter.electronicAdapter
import com.osamadev.mobilecomputingassg2.Adapter.foodAdapter
import com.osamadev.mobilecomputingassg2.DB.database
import com.osamadev.mobilecomputingassg2.R
import kotlinx.android.synthetic.main.activity_secound.*

class SecoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)

        var db = database(this)
        var type = intent.getStringExtra("type")

        if (type == "food"){
            val array = db.getAllFood()
            var adapter = foodAdapter(this,array)
            secound_recycler.layoutManager = LinearLayoutManager(this)
            secound_recycler.adapter = adapter
        }else if(type == "electronic"){
            val array = db.getAllElectronic()
            var adapter = electronicAdapter(this,array)
            secound_recycler.layoutManager = LinearLayoutManager(this)
            secound_recycler.adapter = adapter
        }else if(type == "clothes"){
            val array = db.getAllClothes()
            var adapter = clothesAdapter(this,array)
            secound_recycler.layoutManager = LinearLayoutManager(this)
            secound_recycler.adapter = adapter
        }

    }
}