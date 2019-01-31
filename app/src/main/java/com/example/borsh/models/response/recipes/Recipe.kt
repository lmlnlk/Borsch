package com.example.borsh.models.response.recipes

import com.google.gson.annotations.SerializedName

class Recipe(
    @SerializedName("name") val name: String,
    @SerializedName("_id") val id: String
)
