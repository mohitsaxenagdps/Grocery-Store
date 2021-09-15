package com.oyelabs.grocerystore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oyelabs.grocerystore.model.BestSellingItem
import com.oyelabs.grocerystore.R
import com.oyelabs.grocerystore.databinding.BestSellingItemBinding

class BestSellingAdapter : RecyclerView.Adapter<BestSellingAdapter.ViewHolder>() {

    private val bestSellingItemList = arrayListOf(
        BestSellingItem(R.drawable.bellpepper, "Bell Pepper Red", "4.99$"),
        BestSellingItem(R.drawable.ginget, "Ginger", "4.99$"),
        BestSellingItem(R.drawable.ginget, "Garlic", "7.99$"),
        BestSellingItem(R.drawable.ginget, "Onion", "12.99$"),
        BestSellingItem(R.drawable.bellpepper, "Bell Pepper Red", "3.99$")
    )

    inner class ViewHolder(private val binding: BestSellingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bestSellingItem: BestSellingItem) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(bestSellingItem.image)
                    .into(imageView)

                tvTitle.text = bestSellingItem.title
                tvPrice.text = bestSellingItem.price
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            BestSellingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bestSellingItemList[position])
    }

    override fun getItemCount() = bestSellingItemList.size

}