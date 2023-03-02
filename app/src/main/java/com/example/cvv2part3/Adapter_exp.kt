package com.example.cvv2part3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter_exp(private val expList : ArrayList<items_exp>) :
    RecyclerView.Adapter<Adapter_exp.MyViewHolder_exp>() {

    class MyViewHolder_exp(itemView: View) : RecyclerView.ViewHolder(itemView){


        val imageViewexp : ShapeableImageView =  itemView.findViewById(R.id.imageViewexp)
        val Nameexp : TextView =  itemView.findViewById(R.id.Nameexp)
        val cuntryexp : TextView =  itemView.findViewById(R.id.cuntryexp)
        val startdatexp : TextView =  itemView.findViewById(R.id.startdatexp)
        val enddatexp : TextView =  itemView.findViewById(R.id.enddatexp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder_exp {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_experience,parent, false)
        return MyViewHolder_exp(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder_exp, position: Int) {
        val currentItem = expList[position]
        holder.imageViewexp.setImageResource(currentItem.imageViewexp)
        holder.Nameexp.text = currentItem.Nameexp
        holder.cuntryexp.text = currentItem.cuntryexp
        holder.startdatexp.text = currentItem.startdatexp
        holder.enddatexp.text = currentItem.enddatexp
    }

    override fun getItemCount(): Int {
        return expList.size
    }


}