package com.example.shoppinglist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Database is a file in which we link all the entities together.
//In this class, you can use your Dao to access the database.
@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase(){

    //Here we define the Dao
    abstract fun getShoppingDao(): ShoppingDao

    //Here we are creating a companion object to make an instance of the Database.
    //We also don't want to create multiple instances of the Database.
    //To solve this we use the synchronized method.
    companion object{
        //Volatile annotation is used to make the instance of the Database visible to all the threads.
        @Volatile
        private var instance: ShoppingDatabase? = null
        //Lock is used to make sure that only one thread can access the database at a time.
        private val LOCK = Any()
        //the operator fun invoke is used to check if an instance of the database already exists.
        //If it does not exist, it creates a new instance of the database and returns it while locking the current thread.
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        //The createDatabase function creates the database and returns it.
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java,
                "shoppingDB.db")
                .build()

    }

}