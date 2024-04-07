package com.example.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.db.ShoppingDatabase
import com.example.shoppinglist.db.entities.ShoppingItem
import com.example.shoppinglist.other.ShoppingItemAdapter
import com.example.shoppinglist.repositories.ShoppingRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

//It is the Main Activity of the Application where the user can see the shopping list
class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        //Initializing the database, repository and view model
        //We will later change this using Dependency Injection.
        //Since it will give us a global space to instantiate database, repository and view model
        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        val recyclerView = findViewById<RecyclerView>(R.id.rvShoppingItems)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)
        //Setting the adapter to the recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        //Observing the list of shopping items
        viewModel.getAllShoppingItems().observe(this, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        floatingActionButton.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show(
        }

    }
}