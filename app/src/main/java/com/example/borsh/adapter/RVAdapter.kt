package com.example.borsh.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.borsh.R
import com.example.borsh.model.Recipe

class RVAdapter(private val mContext: Context?, private val mRecipe: List<Recipe>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mRecipe.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = mRecipe[position]
        holder.title.text = recipe.title
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var title: TextView

        init{

            title = itemView.findViewById(R.id.title)
        }
    }
}