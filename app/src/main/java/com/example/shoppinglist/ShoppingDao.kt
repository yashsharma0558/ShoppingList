package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Dao stands for Data Access Object, in this file, we create an interface for the Room Database.
//It consists of all the database operations that you will use in your application like, insert, delete, update, etc.
@Dao
interface ShoppingDao {

    //This function updates and inserts the data into the database.
    // If the item already exists, it will be updated using the OnConflictStrategy.REPLACE.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    //This function deletes the data from the database.
    @Delete
    suspend fun delete(item: ShoppingItem)

    //This function gets all the data from the database.
    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

}