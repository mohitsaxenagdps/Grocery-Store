package com.oyelabs.grocerystore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.oyelabs.grocerystore.adapter.BestSellingAdapter
import com.oyelabs.grocerystore.adapter.ExclusiveItemAdapter
import com.oyelabs.grocerystore.adapter.GroceryAdapter
import com.oyelabs.grocerystore.adapter.SliderAdapter
import com.oyelabs.grocerystore.databinding.FragmentHomeBinding
import com.oyelabs.grocerystore.model.GroceryItem
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val sliderAdapter = SliderAdapter()
        val exclusiveItemAdapter = ExclusiveItemAdapter()
        val bestSellingAdapter = BestSellingAdapter()
        val groceryAdapter = GroceryAdapter { groceryItem ->
            groceryItemClick(groceryItem)
        }

        binding.slider.apply {
            autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
            setSliderAdapter(sliderAdapter)
            scrollTimeInSec = 2
            isAutoCycle = true
            startAutoCycle()
        }

        binding.exclusiveRecyclerView.apply {
            adapter = exclusiveItemAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.bestSellingRecyclerView.apply {
            adapter = bestSellingAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.groceriesRecyclerView.apply {
            adapter = groceryAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        return binding.root

    }

    private fun groceryItemClick(groceryItem: GroceryItem) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(groceryItem)
        findNavController().navigate(action)
    }

}