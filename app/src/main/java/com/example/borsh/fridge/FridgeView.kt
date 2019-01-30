package com.example.borsh.fridge


interface FridgeView {
    fun showFridge(ingredients: List<String>)
    fun showBodyIsNullError()
}