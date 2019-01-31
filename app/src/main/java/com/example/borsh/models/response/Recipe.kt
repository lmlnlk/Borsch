package com.example.borsh.models.response

import com.google.gson.annotations.SerializedName

class Recipe (
//    @SerializedName("done")var done: Boolean,
//    @SerializedName("_id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("ingredient") var ingredient: List<String>)
//class Ingredients(
//)