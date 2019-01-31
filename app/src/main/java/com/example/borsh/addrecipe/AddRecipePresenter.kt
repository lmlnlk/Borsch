package com.example.borsh.addrecipe

import android.util.Log
import com.example.borsh.App
import com.example.borsh.models.response.contentrecipe.IngredientObj
import com.example.borsh.models.response.fridge.IngredientResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddRecipePresenter {

    private var view: AddRecipeView? = null

    fun bindView(view: AddRecipeView) {
        this.view = view
        updateAddRecipe()
    }

    private fun updateAddRecipe(){
//        App.api
//            .addRecipe()
//            .enqueue(object : Callback<IngredientObj> {
//                override fun onFailure(call: Call<IngredientObj>, t: Throwable) {
//
//                }
//
//                override fun onResponse(call: Call<IngredientObj>, response: Response<IngredientObj>) {
//                    val ingredients = response.body()?.ingredient?.name?.map { it. }
//
//                    Log.i("Ingredients = ", ingredients.toString())
//                    Log.i("STATUS = ", response.code().toString())
//
//                    if(ingredients != null){
//                        view?.showFridge(ingredients)
//                    }
//                }
//
//            })
    }

    fun unbindView() {
        this.view = null
    }
}