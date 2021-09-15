package com.oyelabs.grocerystore.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.oyelabs.grocerystore.databinding.FragmentDetailsBinding
import com.oyelabs.grocerystore.model.GroceryItem

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val groceryItem = arguments?.getParcelable<GroceryItem>("groceryItem")!!

        Glide.with(binding.root.context)
            .load(groceryItem.image)
            .into(binding.imageView)

        binding.apply {
            tvTitle.text = groceryItem.title
            tvDescription.text = groceryItem.description
        }

        binding.btBack.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root

    }

}