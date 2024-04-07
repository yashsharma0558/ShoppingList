package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.db.entities.ShoppingItem

class AddShoppingItemDialog(context: Context, var addDialogListner : AddDialogListener) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.dialog_add_shopping_item)
        super.onCreate(savedInstanceState)
        val addButton  = findViewById<TextView>(R.id.tvAdd)
        addButton?.setOnClickListener{
            val name = findViewById<EditText>(R.id.etName)?.text.toString()
            val amount = findViewById<EditText>(R.id.etAmount)?.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please enter all information! !", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name, amount.toInt())
            addDialogListner.onAddButtonClicked(item)
            dismiss()

        }
        val cancelButton = findViewById<TextView>(R.id.tvCancel)
        cancelButton?.setOnClickListener{
            cancel()
        }
    }
}