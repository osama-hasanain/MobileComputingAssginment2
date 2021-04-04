package com.osamadev.mobilecomputingassg2.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.osamadev.mobilecomputingassg2.Activity.ThirdActivity
import com.osamadev.mobilecomputingassg2.R
import com.osamadev.mobilecomputingassg2.model.food

class foodAdapter(var context: Activity,var array:ArrayList<food>) : RecyclerView.Adapter<foodAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var root = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = array[position].name
        holder.img.setImageResource(array[position].img)
        holder.card.setOnClickListener {
            var i = Intent(context,ThirdActivity::class.java)
            i.putExtra("itemFood",array[position])
            context.startActivity(i)
        }
    }
    class MyViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){
        var card : FrameLayout
        var img : ImageView
        var title : TextView
        init {
            card = itemview.findViewById(R.id.item_card)
            img = itemview.findViewById(R.id.item_img)
            title = itemview.findViewById(R.id.item_title)
        }

    }
}