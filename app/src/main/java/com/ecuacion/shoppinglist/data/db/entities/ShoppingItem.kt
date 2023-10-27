package com.ecuacion.shoppinglist.data.db.entities


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Shopping_items")
data class ShoppingItem(

    val name: String,
    var amount: Int,

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    )