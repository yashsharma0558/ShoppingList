package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.db.entities.ShoppingItem
import com.example.shoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//ViewModel is used to store data of an activity so that when the configuration changes the data is not lost.
//The Views will directly fetch the data stored in the ViewModel and show it on the UI
//The View model gets its data from the repository.
//When we pass the repository as a parameter, we need to build a ViewModelFactory.

class ShoppingViewModel(private val shoppingRepository: ShoppingRepository): ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        shoppingRepository.upsert(item)
    }

    fun delete(item :ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        shoppingRepository.delete(item)

    }
    fun getAllShoppingItems() = shoppingRepository.getAllShoppingItems()

}