package com.example.borsh.recipes

import com.example.borsh.App
import com.example.borsh.models.api.Api
import com.example.borsh.models.response.RecipeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeListPresenter {
    private var view: RecipeView? = null

    fun bindView(view: RecipeView){
        this.view = view
        updateRecipe()
    }

    private fun updateRecipe() {
        App.retrofit
            .create(Api::class.java)
            .getAllRecipe()
            .enqueue(object : Callback<RecipeResponse> {
                override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                    val recipes = response.body()?.results?.map { it.name }

                    if (recipes != null) {
                        view?.showRecipe(recipes)
                    }
                }
            })
         //view?.showRecipe((1..100).map { "Recipe $it" })
    }

    fun unbindView(){
        this.view = null
    }
}