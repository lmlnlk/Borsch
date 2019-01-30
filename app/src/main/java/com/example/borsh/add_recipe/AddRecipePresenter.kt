package com.example.borsh.add_recipe

import com.example.borsh.App
import com.example.borsh.models.response.AllIngredientsRespons
import javax.security.auth.callback.Callback

class AddRecipePresenter {
    private var view: AddRecipeVeiw? = null

    fun bindView(view: AddRecipeVeiw){
        this.view = view
        updateAddRecipe()
    }

    private fun updateAddRecipe(){
        App.api
            .getAllIngredients()
            .enqueue(object : Callback<AllIngredientsRespons>)


    }

    fun unbindView(){
        this.view = null
    }
}