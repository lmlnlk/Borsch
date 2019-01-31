package com.example.borsh.recipes

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsh.R
import com.example.borsh.ingredients.EXTRA_ID
import com.example.borsh.ingredients.RecipeActivity
import com.example.borsh.models.response.recipes.Recipe
import kotlinx.android.synthetic.main.item.view.*

class RVAdapter : RecyclerView.Adapter<RecipeHolder>() {

    private val recipes: MutableList<Recipe> = mutableListOf()

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
    }

    fun setPersons(recipe: List<Recipe>) {
        this.recipes.clear()
        this.recipes.addAll(recipe)
        notifyDataSetChanged()
    }
}

class RecipeHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var id: String = ""

    fun bind(recipe: Recipe) {
        itemView.title_recipe.text = recipe.name
        id = recipe.id
    }

    init {
        itemView.setOnClickListener {
            val recipeIntent = Intent(itemView.context, RecipeActivity::class.java)
            recipeIntent.putExtra(EXTRA_ID, id)
            itemView.context.startActivity(recipeIntent)
        }
    }
}