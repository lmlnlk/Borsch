package com.example.borsh.addrecipe

import com.example.borsh.models.response.fridge.Ingredient

interface AddRecipeView {
    fun showAddRecipe(allIngredients: List<String>)
    fun showIngredients(ingredientList: List<String>)
}