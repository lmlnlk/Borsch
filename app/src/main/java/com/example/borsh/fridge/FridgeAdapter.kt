package com.example.borsh.fridge

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsh.R
import kotlinx.android.synthetic.main.ingregient_item.view.*

class FridgeAdapter(private val isSelectEnabled: Boolean): RecyclerView.Adapter<FridgeHolder>() {

    private val list = mutableListOf<Pair<Boolean, String>>()

    private val ingredients: List<String>
    get() = list.map { it.second }

    val selectedIngredients: List<String>
        get() = list.filter { it.first }.map { it.second }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FridgeHolder =
        FridgeHolder(LayoutInflater.from(parent.context).inflate(R.layout.ingregient_item, parent, false))

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: FridgeHolder, position: Int) {
        val title = ingredients[position]
        holder.bind(title)
        holder.itemView.setOnClickListener {
            if (isSelectEnabled) {
                val pair = list[position]
                list.removeAt(position)
                list.add(position, !pair.first to pair.second)

                if (!pair.first) holder.swapBackGroundSeleted()
                else holder.swapBackGroundUnseleted()
            }
        }
    }

    fun setIngredient(ingredient: List<String>){

        val map = ingredient.map { false to it }

        list.clear()
        list.addAll(map)

        notifyDataSetChanged()
    }
}

class FridgeHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(title: String){
        itemView.ingredient_item.text = title
    }

    fun swapBackGroundUnseleted() {
        itemView.setBackgroundColor(999)
    }

    fun swapBackGroundSeleted() {
        itemView.setBackgroundColor(889)
    }


}