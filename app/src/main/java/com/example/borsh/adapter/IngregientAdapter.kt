package com.example.borsh.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.borsh.R
import com.example.borsh.model.Ingregient

class IngregientAdapter (private val mContext: Context?, private val mIntregient: List<Ingregient>): RecyclerView.Adapter<IngregientAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.ingregient_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mIntregient.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient = mIntregient[position]
        holder.ingredient.text = ingredient.title
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var ingredient: TextView

        init{

            ingredient = itemView.findViewById(R.id.ingredient)
        }
    }
}