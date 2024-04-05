package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.repositories.ShoppingRepository

//ViewModelFactory is used to create a new instance of ViewModel.
@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(private val shoppingRepository: ShoppingRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepository) as T
    }
}