package com.example.borsh.ingredients

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsh.R
import kotlinx.android.synthetic.main.struct_recipe_item.view.*

class IngredientAdapter : RecyclerView.Adapter<IngredientHolder>() {

    private val ingredients: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): IngredientHolder =
        IngredientHolder(LayoutInflater.from(parent.context).inflate(R.layout.struct_recipe_item, parent, false))

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    fun setInstance(ingredients: List<String>){
        this.ingredients.clear()
        this.ingredients.addAll(ingredients)
        notifyDataSetChanged()
    }
}

class IngredientHolder(view: View) : RecyclerView.ViewHolder(view){
    fun bind(title: String){
        itemView.title_ingredient.text = title
    }
}