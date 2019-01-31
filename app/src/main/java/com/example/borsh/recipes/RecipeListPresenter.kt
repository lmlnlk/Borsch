package com.example.borsh.recipes

import android.net.http.HttpResponseCache
import android.util.Log
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
        App.api
            .getAllRecipe()
            .enqueue(object : Callback<RecipeResponse> {
                override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                    Log.e("asd", t.message)
                }

                override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                    val recipes = response.body()?.content?.map { it.name }

                    Log.i("Recipes = ", recipes.toString())
                    Log.i("STATUS = ", response.code().toString())

                    if (recipes != null) {
                        view?.showRecipe(recipes)
                    }
                }
            })
    }

    fun unbindView(){
        this.view = null
    }
}