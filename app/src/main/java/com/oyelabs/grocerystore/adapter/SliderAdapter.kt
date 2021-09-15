package com.oyelabs.grocerystore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.oyelabs.grocerystore.R
import com.oyelabs.grocerystore.databinding.SliderLayoutBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter : SliderViewAdapter<SliderAdapter.ViewHolder>() {

    private val sliderList = arrayListOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)

    override fun getCount() = sliderList.size

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val binding =
            SliderLayoutBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        viewHolder?.bind(sliderList[position])
    }

    inner class ViewHolder(private val binding: SliderLayoutBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(image: Int) {
            Glide.with(binding.root.context)
                .load(image)
                .into(binding.imageView)
        }
    }

}