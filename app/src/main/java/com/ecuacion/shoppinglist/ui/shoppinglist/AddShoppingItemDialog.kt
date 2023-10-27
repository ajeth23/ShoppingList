package com.ecuacion.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.ecuacion.shoppinglist.R
import com.ecuacion.shoppinglist.data.db.entities.ShoppingItem

class AddShoppingItemDialog(context: Context, var AddDialogListener: AddDialogListener) :
    AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        val tvCancel = findViewById<TextView>(R.id.tvCancel)
        val etName = findViewById<TextView>(R.id.etName)
        val etAmount = findViewById<TextView>(R.id.etAmount)

        tvAdd?.setOnClickListener {
            val name = etName?.text.toString()
            val amount = etAmount?.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please Enter all the Information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            AddDialogListener.onAddButtonClicked(item)
            dismiss()

        }

        tvCancel?.setOnClickListener {
            cancel()
        }

    }


}