package com.example.borsh.add_recipe

import android.util.Log
import com.example.borsh.App
import com.example.borsh.models.response.AllIngredientsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class AddRecipePresenter {
    private var view: AddRecipeVeiw? = null

    fun bindView(view: AddRecipeVeiw) {
        this.view = view
        updateAddRecipe()
    }

    private fun updateAddRecipe() {

        App.api
            .getAllIngredients()
            .enqueue(object : Callback<AllIngredientsResponse> {
                override fun onFailure(call: Call<AllIngredientsResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<AllIngredientsResponse>,response: Response<AllIngredientsResponse>){
                    val ingredients = response.body()?.content?.allingredients?.map { it.ingredient }


                    if (ingredients!= null)
                        view.

                }

            })

    }


}