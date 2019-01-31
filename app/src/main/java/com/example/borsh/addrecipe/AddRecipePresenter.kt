package com.example.borsh.addrecipe

import android.util.Log
import com.example.borsh.App
import com.example.borsh.models.request.AddRecipeRequest
import com.example.borsh.models.response.AllIngredientResponse
import com.example.borsh.models.response.contentrecipe.IngredientObj
import com.example.borsh.models.response.fridge.IngredientResponse
import com.example.borsh.models.response.recipes.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddRecipePresenter {

    private val recipe: Recipe = Recipe("", "", mutableListOf())
    private var view: AddRecipeView? = null

    fun bindView(view: AddRecipeView) {
        this.view = view
        updateAddRecipe()
    }

    private fun updateAddRecipe() {
        App.api
            .getAllIngredients()
            .enqueue(object : Callback<AllIngredientResponse> {
                override fun onFailure(call: Call<AllIngredientResponse>, t: Throwable) {}

                override fun onResponse(
                    call: Call<AllIngredientResponse>,
                    response: Response<AllIngredientResponse>
                ) {
                    val ingredients = response.body()?.content?.map { it.name }

                    if (ingredients != null)
                        view?.showIngredients(ingredients)
                }
            })
    }

    private fun AddNewRecipe() {
        App.api
            .addRecipe(recipe)
            .enqueue(object : Callback<AddRecipeRequest> {
                override fun onFailure(call: Call<AddRecipeRequest>, t: Throwable) {}

                override fun onResponse(
                    call: Call<AddRecipeRequest>,
                    response: Response<AddRecipeRequest>
                ) {
                    val flag = response.body()?.success
                    if (flag == true) {
                        view?.showIngredients(recipe.ingredient)
                    }
                }
            })
    }


    fun changeName(name: String) {
        recipe.name = name

    }

    fun createReceipt(ingredientList: List<String>) {
        recipe.ingredient = ingredientList
        AddNewRecipe()
    }


    fun unbindView() {
        this.view = null
    }
}