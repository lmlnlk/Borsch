package com.example.borsh.fridge

import com.example.borsh.App
import com.example.borsh.models.api.Api
import com.example.borsh.models.response.IngredientResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FridgeListPresenter {

    private var view: FridgeView? = null

    fun bindView(view: FridgeView){
        this.view = view
        updateIngredient()
    }

    private fun updateIngredient(){
        App.retrofit
            .create(Api::class.java)
            .getAllIngredient()
            .enqueue(object : Callback<IngredientResponse>{
                override fun onFailure(call: Call<IngredientResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<IngredientResponse>, response: Response<IngredientResponse>) {
                    val ingredients = response.body()?.results?.map { it.name }

                    if(ingredients != null){
                        view?.showFridge(ingredients)
                    }
                }

            })
    }

    fun unbindView(){
        this.view = null
    }
}