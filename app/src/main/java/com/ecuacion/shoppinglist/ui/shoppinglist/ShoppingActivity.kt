package com.ecuacion.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecuacion.shoppinglist.R
import com.ecuacion.shoppinglist.adapter.ShoppingItemAdapter
import com.ecuacion.shoppinglist.data.db.ShoppingDatabase
import com.ecuacion.shoppinglist.data.db.entities.ShoppingItem
import com.ecuacion.shoppinglist.data.repositories.ShoppingRepositories
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShoppingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepositories(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.insert(item)
                    }
                }).show()
        }
    }

}