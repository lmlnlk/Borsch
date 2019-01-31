package com.example.borsh.recipes

import com.example.borsh.models.response.recipes.Recipe

interface RecipeView {
    fun showRecipe(recipes: List<Recipe>)
}