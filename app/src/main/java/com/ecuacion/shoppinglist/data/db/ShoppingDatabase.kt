package com.ecuacion.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ecuacion.shoppinglist.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 2
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        // This function is executed whenever we create an instance of the ShoppingDatabase
        operator fun invoke(context: Context) =
            instance ?: synchronized(LOCK) {
                instance ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "shoppingDB.db"
            ).fallbackToDestructiveMigration().build()


    }
}