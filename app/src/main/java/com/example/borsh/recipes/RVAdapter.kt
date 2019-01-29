package com.example.borsh.recipes

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsh.Interface.ItemClickListener
import com.example.borsh.R
import com.example.borsh.RecipeActivity
import kotlinx.android.synthetic.main.item.view.*

class RVAdapter(var mContext: Context): RecyclerView.Adapter<RecipeHolder>(){

    private val recipes: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder =
        RecipeHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(recipes[position])

        holder.setItemClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {
            val recipeIntent = Intent(mContext, RecipeActivity::class.java)
                mContext.startActivity(recipeIntent)
            }
        })
    }

    fun setPersons(recipe: List<String>){
        this.recipes.clear()
        this.recipes.addAll(recipe)
        notifyDataSetChanged()
    }
}

class RecipeHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

    private var itemClickListener: ItemClickListener? = null

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun onClick(view: View?) {
        itemClickListener!!.onClick(view!!, adapterPosition)
    }

    fun bind(title: String){
        itemView.title_recipe.text = title
    }

    init{

        itemView.setOnClickListener(this)
    }
}