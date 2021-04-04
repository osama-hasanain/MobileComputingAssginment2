package com.osamadev.mobilecomputingassg2.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osamadev.mobilecomputingassg2.R
import com.osamadev.mobilecomputingassg2.model.clothes
import com.osamadev.mobilecomputingassg2.model.electronic
import com.osamadev.mobilecomputingassg2.model.food
import kotlinx.android.synthetic.main.activity_third.*
import java.io.Serializable

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        var iClothe:Serializable?= intent.getSerializableExtra("itemClothes")
        var iElectronic:Serializable? = intent.getSerializableExtra("itemElectronic")
        var iFood:Serializable?= intent.getSerializableExtra("itemFood")

        if (iClothe != null ){
            iClothe as clothes
            third_img.setImageResource(iClothe.img)
            third_title.text = iClothe.name
            third_price.text = iClothe.price.toString()+ "$"
            third_desc.text = iClothe.desc.toString()
        }else if (iElectronic != null){
            iElectronic as electronic
            third_img.setImageResource(iElectronic.img)
            third_title.text = iElectronic.name
            third_price.text = iElectronic.price.toString()+ "$"
            third_desc.text = iElectronic.desc.toString()
        }else{
            iFood as food
            third_img.setImageResource(iFood.img)
            third_title.text = iFood.name
            third_price.text = iFood.price.toString() + "$"
            third_desc.text = iFood.desc.toString()
        }

    }
}