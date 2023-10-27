package com.ecuacion.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecuacion.shoppinglist.R
import com.ecuacion.shoppinglist.data.db.entities.ShoppingItem
import com.ecuacion.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)

        return ShoppingViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItems = items[position]

        // Find the views in the item layout
        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
        val tvAmount = holder.itemView.findViewById<TextView>(R.id.tvAmount)
        val ivDelete = holder.itemView.findViewById<ImageView>(R.id.ivDelete)
        val ivPlus = holder.itemView.findViewById<ImageView>(R.id.ivPlus)
        val ivMinus = holder.itemView.findViewById<ImageView>(R.id.ivMinus)

        // Set  views
        tvName.text = curShoppingItems.name
        tvAmount.text = "${curShoppingItems.amount}"

        ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItems)
        }

        ivPlus.setOnClickListener {
            viewModel.insert(curShoppingItems)
        }

        ivMinus.setOnClickListener {
            if (curShoppingItems.amount > 0) {
                curShoppingItems.amount--
                viewModel.insert(curShoppingItems)
            }
        }


    }

}