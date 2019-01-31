package com.example.borsh.recipes

import android.util.Log
import com.example.borsh.App
import com.example.borsh.models.response.recipes.RecipeResponse
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
        App.api
            .getAllRecipe()
            .enqueue(object : Callback<RecipeResponse> {
                override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                    Log.e("asd", t.message)
                }

                override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                    val recipes = response.body()?.content
                    val id = response.body()?.content?.map { it.id }

                    Log.i("ID = ", id.toString())
                    Log.i("Recipes = ", recipes.toString())
                    Log.i("STATUS = ", response.code().toString())

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