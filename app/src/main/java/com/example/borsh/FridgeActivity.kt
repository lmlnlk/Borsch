package com.example.borsh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.borsh.adapter.IngregientAdapter
import com.example.borsh.adapter.RVAdapter
import com.example.borsh.model.Ingregient

class FridgeActivity : AppCompatActivity() {

    private var ingregient: List<Ingregient> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Ингредиенты"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initIngredient()

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        // linearLayoutManager.stackFromEnd = true
        recyclerView.layoutManager = linearLayoutManager
        val adapter = IngregientAdapter(this, ingregient)

        recyclerView.adapter = adapter
    }

    private fun initIngredient(){
        (ingregient as ArrayList<Ingregient>).add(Ingregient("Картошка"))
        (ingregient as ArrayList<Ingregient>).add(Ingregient("Лук"))
        (ingregient as ArrayList<Ingregient>).add(Ingregient("Рис"))
    }
}
