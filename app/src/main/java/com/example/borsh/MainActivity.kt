package com.example.borsh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.borsh.adapter.RVAdapter
import com.example.borsh.model.Recipe
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    private var recipes: List<Recipe> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initData()

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
       // linearLayoutManager.stackFromEnd = true
        recyclerView.layoutManager = linearLayoutManager
        val adapter = RVAdapter(this, recipes)

        recyclerView.adapter = adapter
    }

    private fun initData(){
        (recipes as ArrayList<Recipe>).add(Recipe("Борщ"))
        (recipes as ArrayList<Recipe>).add(Recipe("Пельмени"))
        (recipes as ArrayList<Recipe>).add(Recipe("Плов"))
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
