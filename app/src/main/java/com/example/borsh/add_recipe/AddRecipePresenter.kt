package com.example.borsh.add_recipe

import com.example.borsh.App
import com.example.borsh.models.response.AllIngredientsResponse
import com.example.borsh.models.response.Recipe
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class AddRecipePresenter {

    private val recipe: Recipe = Recipe("", mutableListOf())

    private var view: AddRecipeVeiw? = null

    fun bindView(view: AddRecipeVeiw) {
        this.view = view
        updateAddRecipe()
    }

    private fun updateAddRecipe() {
        App.api
            .getAllIngredients()
            .enqueue(object : Callback<AllIngredientsResponse> {
                override fun onFailure(call: Call<AllIngredientsResponse>, t: Throwable) {}

                override fun onResponse(
                    call: Call<AllIngredientsResponse>,
                    response: Response<AllIngredientsResponse>
                ) {
                    val ingredients = response.body()?.content?.allingredients?.map { it.ingredient.name }

                    if (ingredients != null)
                        view?.showIngredients(ingredients)
                }
            })
    }

    fun changeName(name: String) {
        recipe.name = name
    }

    fun createReceipt(ingredientList: List<String>) {
        recipe.ingredient = ingredientList
    }

    fun unbindView() {
        this.view = null
    }
}