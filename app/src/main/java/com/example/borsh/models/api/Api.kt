package com.example.borsh.models.api

import com.example.borsh.models.response.AllIngredientsResponse
import com.example.borsh.models.response.IngredientResponse
import com.example.borsh.models.response.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("/recipe")
    fun getAllRecipe(): Call<RecipeResponse>

    @GET("/user/5c4edc01fc79b221b47f0d68/fridge")
    fun getPersonIngredients(): Call<IngredientResponse>

    @GET("/ingredients")
    fun getAllIngredients(): Call<AllIngredientsResponse>

}