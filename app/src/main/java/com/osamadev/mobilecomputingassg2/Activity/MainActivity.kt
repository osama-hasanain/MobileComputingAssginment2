package com.osamadev.mobilecomputingassg2.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.osamadev.mobilecomputingassg2.DB.database
import com.osamadev.mobilecomputingassg2.R
import com.osamadev.mobilecomputingassg2.model.clothes
import com.osamadev.mobilecomputingassg2.model.electronic
import com.osamadev.mobilecomputingassg2.model.food
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var db : database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = database(this)

        main_food.setOnClickListener(this)
        main_electronic.setOnClickListener(this)
        main_clothes.setOnClickListener(this)


        val sharedPref = getSharedPreferences("IsFirst", Context.MODE_PRIVATE)
        val isActive = sharedPref.getBoolean("isFirst",false)

        if (!isActive)
            isFirst()
    }

    fun isFirst(){
        db.insertFood(food(0,"Shawarma","Chicken breast with saj bread",10,R.drawable.img_sharwema))
        db.insertFood(food(0,"Kabab","Minced and grilled chicken on charcoal",40,R.drawable.img_kebab))
        db.insertFood(food(0,"Leg","Chicken thigh with rusk",60,R.drawable.test_img))
        Log.e("osm",db.getAllFood().size.toString())

        db.insertElectronic(electronic(0,"Mac lab","Intel Core i9 octa-core processor with a frequency of 2.4GHz",1500,R.drawable.mac))
        db.insertElectronic(electronic(0,"IPhone 9","Powered by a 2050 mAh battery. Connectivity features in the smartphone include WiFi.",500,R.drawable.phone))
        db.insertElectronic(electronic(0,"HP lab","Central processor: 8th generation Intel core i5 RAM: 8 GB, full-screen 17-inch keyboard",300,R.drawable.lab))
        Log.e("osm",db.getAllElectronic().size.toString())

        db.insertClothe(clothes(0,"Jacket","A technician from time to time lanthanum float knows the specifications of a reflective jacket",150,R.drawable.jacket))
        db.insertClothe(clothes(0,"Blouse","Powered and buteful , good for make your happy ",50,R.drawable.blouse))
        db.insertClothe(clothes(0,"Dress","The women's dress or dress (intruder Albanian) This garment (dress) includes an upper robe and a lower tip ",200,R.drawable.dress))
        Log.e("osm",db.getAllClothes().size.toString())

        val sharedPref = getSharedPreferences("IsFirst", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("isFirst",true)
        editor.apply()
        editor.commit()

    }

    override fun onClick(v: View?) {
       when(v){
           main_food ->{
               var i = Intent(this,SecoundActivity::class.java)
               i.putExtra("type","food")
               startActivity(i)
           }
           main_electronic ->{
               var i = Intent(this,SecoundActivity::class.java)
               i.putExtra("type","electronic")
               startActivity(i)
           }
           main_clothes ->{
               var i = Intent(this,SecoundActivity::class.java)
               i.putExtra("type","clothes")
               startActivity(i)
           }
       }
    }
}