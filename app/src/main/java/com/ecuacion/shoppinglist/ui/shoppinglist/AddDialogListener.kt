package com.ecuacion.shoppinglist.ui.shoppinglist

import com.ecuacion.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}