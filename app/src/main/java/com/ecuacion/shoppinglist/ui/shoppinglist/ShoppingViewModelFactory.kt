package com.ecuacion.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ecuacion.shoppinglist.data.repositories.ShoppingRepositories

class ShoppingViewModelFactory(

    private val repository: ShoppingRepositories
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }

}