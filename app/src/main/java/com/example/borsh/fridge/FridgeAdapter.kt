package com.example.borsh.fridge

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsh.R
import kotlinx.android.synthetic.main.ingregient_item.view.*

class FridgeAdapter: RecyclerView.Adapter<IngredientAdapter>() {

    private val ingredients: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): IngredientAdapter =
        IngredientAdapter(LayoutInflater.from(parent.context).inflate(R.layout.ingregient_item, parent, false))

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientAdapter, position: Int) {
        holder.bind(ingredients[position])
    }

    fun setIngredient(ingredient: List<String>){
        this.ingredients.clear()
        this.ingredients.addAll(ingredient)
        notifyDataSetChanged()
    }
}

class IngredientAdapter(view: View): RecyclerView.ViewHolder(view){
    fun bind(title: String){
        itemView.ingredient_item.text = title
    }
}