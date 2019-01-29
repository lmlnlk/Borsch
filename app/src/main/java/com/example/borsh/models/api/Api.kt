package com.example.borsh.models.api

import com.example.borsh.models.response.IngredientResponse
import com.example.borsh.models.response.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("people")
    fun getAllRecipe(): Call<RecipeResponse>

    @GET("planets")
    fun getAllIngredient(): Call<IngredientResponse>
}