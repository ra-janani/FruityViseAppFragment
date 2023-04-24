package com.example.fruityviseapp.ui.fragments.detail_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.fruityviseapp.data.FruityViceItemModel
import com.example.fruityviseapp.data.NutritionsModel
import com.example.fruityviseapp.databinding.FragmentDetailsBinding
import com.example.fruityviseapp.ui.FruitsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    //private val detailViewModel by activityViewModels<FruitsViewModel>()

   private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayNutritions(args.currentItem)
    }


    private fun displayNutritions(fruits: FruityViceItemModel){


        val nutritions: NutritionsModel? = fruits.nutritions

        binding.tvFruitName.text = fruits.name
        binding.tvCalories.text = nutritions?.calories.toString()
        binding.tvCarbohydrates.text = nutritions?.carbohydrates.toString()
        binding.tvFat.text = nutritions?.fat.toString()
        binding.tvProtein.text = nutritions?.protein.toString()
        binding.tvSugar.text = nutritions?.sugar.toString()

    }


}