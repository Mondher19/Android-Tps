package com.example.cvv2part3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter_edu(private val eduList : ArrayList<item_edu>) :
    RecyclerView.Adapter<Adapter_edu.MyViewHolder_edu>() {

    class MyViewHolder_edu(itemView: View) : RecyclerView.ViewHolder(itemView){


        val imageViewedu : ShapeableImageView =  itemView.findViewById(R.id.imageViewedu)
        val cuntryedu : TextView =  itemView.findViewById(R.id.cuntryedu)
        val placeedu : TextView =  itemView.findViewById(R.id.placeedu)
        val startdatedu : TextView =  itemView.findViewById(R.id.startdatedu)
        val enddatedu : TextView =  itemView.findViewById(R.id.enddatedu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder_edu {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_education,parent, false)
        return MyViewHolder_edu(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder_edu, position: Int) {
        val currentItem = eduList[position]
        holder.imageViewedu.setImageResource(currentItem.imageViewedu)
        holder.cuntryedu.text = currentItem.cuntryedu
        holder.placeedu.text = currentItem.placeedu
        holder.startdatedu.text = currentItem.startdatedu
        holder.enddatedu.text = currentItem.enddatedu
    }

    override fun getItemCount(): Int {
        return eduList.size
    }


}