package com.example.borsh.addrecipe

import com.example.borsh.models.response.fridge.Ingredient

interface AddRecipeView {
    fun showAddElements(allIngredient: List<String>)
}