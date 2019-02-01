package com.example.borsh.recipes

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.borsh.R
import com.example.borsh.addrecipe.AddRecipeActivity
import com.example.borsh.fridge.FridgeActivity
import com.example.borsh.models.response.recipes.Recipe
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), RecipeView {

    private val presenter = RecipeListPresenter()
    private val adapter = RVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mainActivityToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        list_recipe.layoutManager = LinearLayoutManager(this)
        list_recipe.adapter = adapter

        add_recipe.setOnClickListener{
            val intent = Intent(this,AddRecipeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun showRecipe(recipes: List<Recipe>) {
        adapter.setPersons(recipes)
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.fridge -> {
                startActivity(Intent(this@MainActivity, FridgeActivity::class.java))
                return true
            }
        }
        return false
    }
}
