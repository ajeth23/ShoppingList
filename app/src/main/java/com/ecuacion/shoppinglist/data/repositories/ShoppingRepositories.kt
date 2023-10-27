package com.ecuacion.shoppinglist.data.repositories

import com.ecuacion.shoppinglist.data.db.ShoppingDatabase
import com.ecuacion.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepositories(
    private val db: ShoppingDatabase

) {


    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()

}