package com.example.borsh.models.api

import com.example.borsh.addrecipe.AddRecipeActivity
import com.example.borsh.addrecipe.AddRecipePresenter
import com.example.borsh.models.request.AddRecipeRequest
import com.example.borsh.models.response.AllIngredientResponse
import com.example.borsh.models.response.contentrecipe.BaseResponse
import com.example.borsh.models.response.contentrecipe.ContentRecipe
import com.example.borsh.models.response.contentrecipe.IngredientObj
import com.example.borsh.models.response.fridge.IngredientResponse
import com.example.borsh.models.response.recipes.Recipe
import com.example.borsh.models.response.recipes.RecipeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @GET("/recipe")
    fun getAllRecipe(): Call<RecipeResponse>

    @GET("/user/5c4edc01fc79b221b47f0d68/fridge")
    fun getAllIngredient(): Call<IngredientResponse>

    @GET("/recipe/{id}")
    fun getStructRecipe(@Path("id") id: String): Call<BaseResponse<ContentRecipe>>

    @GET("/ingredient")
    fun getAllIngredients(): Call<AllIngredientResponse>

    @POST("/recipe/")
    fun addRecipe(@Body receipt: Recipe): Call<AddRecipeRequest>



}