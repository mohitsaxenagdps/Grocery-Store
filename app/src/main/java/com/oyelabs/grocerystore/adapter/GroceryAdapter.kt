package com.oyelabs.grocerystore.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oyelabs.grocerystore.model.GroceryItem
import com.oyelabs.grocerystore.R
import com.oyelabs.grocerystore.databinding.GroceryItemBinding


class GroceryAdapter(private val clickListener: (GroceryItem) -> Unit) :
    RecyclerView.Adapter<GroceryAdapter.ViewHolder>() {

    private val groceryItemList = arrayListOf(
        GroceryItem(R.drawable.pulses_big, "Pulses", "1kg, Price"),
        GroceryItem(R.drawable.rice, "Rice", "2kg, Price"),
        GroceryItem(R.drawable.pulses_big, "Pulses", "1kg, Price"),
        GroceryItem(R.drawable.rice, "Rice", "3kg, Price"),
        GroceryItem(R.drawable.pulses_big, "Pulses", "5kg, Price")
    )

    inner class ViewHolder(private val binding: GroceryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: (GroceryItem) -> Unit, groceryItem: GroceryItem) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(groceryItem.image)
                    .into(imageView)

                tvTitle.text = groceryItem.title

                val shape = GradientDrawable()
                shape.cornerRadius = 30f

                if (groceryItem.title == "Pulses") {
                    shape.setColor(Color.parseColor("#26F8A44C"))
                } else {
                    shape.setColor(Color.parseColor("#2653B175"))
                }
                itemLayout.background = shape

                itemLayout.setOnClickListener {
                    clickListener(groceryItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            GroceryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clickListener, groceryItemList[position])
    }

    override fun getItemCount() = groceryItemList.size

}