package com.oyelabs.grocerystore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oyelabs.grocerystore.model.ExclusiveItem
import com.oyelabs.grocerystore.R
import com.oyelabs.grocerystore.databinding.ExclusiveItemBinding

class ExclusiveItemAdapter : RecyclerView.Adapter<ExclusiveItemAdapter.ViewHolder>() {

    private val exclusiveItemList = arrayListOf(
        ExclusiveItem(R.drawable.banana, "Organic Bananas", "7pcs, Priceg", "4.99$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "1kg, Priceg", "4.99$"),
        ExclusiveItem(R.drawable.banana, "Raw Bananas", "12pcs, Priceg", "7.99$"),
        ExclusiveItem(R.drawable.apple, "Bloody Apple", "3kg, Priceg", "12.99$"),
        ExclusiveItem(R.drawable.banana, "Organic Bananas", "4pcs, Priceg", "3.99$")
    )

    inner class ViewHolder(private val binding: ExclusiveItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exclusiveItem: ExclusiveItem) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(exclusiveItem.image)
                    .into(imageView)

                tvTitle.text = exclusiveItem.title
                tvDescription.text = exclusiveItem.description
                tvPrice.text = exclusiveItem.price
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ExclusiveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exclusiveItemList[position])
    }

    override fun getItemCount() = exclusiveItemList.size

}