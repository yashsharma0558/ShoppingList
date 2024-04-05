package com.example.shoppinglist.repositories

import com.example.shoppinglist.db.ShoppingDatabase
import com.example.shoppinglist.db.entities.ShoppingItem

//Repository is a class that is responsible for fetching data from the database using Dao.
//In this class, we will call the methods that we defined in the Dao and we will pass the required parameters.
class ShoppingRepository(
    private val db : ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()


}