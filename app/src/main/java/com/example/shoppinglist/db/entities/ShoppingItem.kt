package com.example.shoppinglist.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Here we define the entity for the SQLite database.
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    //All the attributes of the table are defined here.
    //ColumnInfo is used to give name to each attribute. If we don't declare this, then it takes name of parameter as its name.
    @ColumnInfo(name = "item_name")
    var name:String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
){
    //Every entity must have a Primary Key.
    //The primary key for shopping_items is auto generated here.
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
