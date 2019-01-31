package com.example.borsh.addrecipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.borsh.R
import kotlinx.android.synthetic.main.activity_add_recipe.*
import kotlinx.android.synthetic.main.ingregient_item.*


class AddRecipeActivity : AppCompatActivity(), AddRecipeView {

    private val presenter = AddRecipePresenter()

    override fun showAddRecipe(allIngredients: List<String>) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Добавить рецепт"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }


        editNameRecipe.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.changeName(text.toString())
            }
        })

        createRecipebtn.setOnClickListener {
            presenter.createReceipt(
                listOf(
                    spinner1.selectedItem as String
                )
            )
        }

    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
        var ingList: MutableList<String> = mutableListOf()

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                ingList.add(parent.getItemAtPosition(position).toString())
            }
        }
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                ingList.add(parent.getItemAtPosition(position).toString())
            }
        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                ingList.add(parent.getItemAtPosition(position).toString())
            }
        }

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                ingList.add(parent.getItemAtPosition(position).toString())
            }
        }


    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun showIngredients(ingredientList: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ingredientList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter
        spinner4.adapter = adapter
    }


}
