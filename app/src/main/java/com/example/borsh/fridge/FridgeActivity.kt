package com.example.borsh.fridge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.borsh.R
import kotlinx.android.synthetic.main.activity_fridge.*

class FridgeActivity : AppCompatActivity(), FridgeView {

    private val presenter = FridgeListPresenter()
    private val adapter = FridgeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge)

        setSupportActionBar(fridgeToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        fridgeToolbar.setNavigationOnClickListener {
            finish()
        }

        ingredient_list.layoutManager = LinearLayoutManager(this)
        ingredient_list.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun showFridge(ingredients: List<String>) {
        adapter.setIngredient(ingredients)
    }

    override fun showBodyIsNullError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}
