package com.example.fruityviseapp.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fruityviseapp.data.FruityViceItemModel
import com.example.fruityviseapp.databinding.FragmentFruitsBinding
import com.example.fruityviseapp.ui.FruitsViewModel
import com.example.fruityviseapp.ui.fragments.detail_page.DetailsFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitsFragment : Fragment() , FruitAdapter.ItemClickListener  {

    private var _binding: FragmentFruitsBinding? = null
    private val binding get() = _binding!!
    private val fruitsViewModel by activityViewModels<FruitsViewModel>()


    private val fruitsAdapter: FruitAdapter by lazy {
        FruitAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFruitsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fruitsViewModel.apply {
            getFruitsData()
            fruits.observe(viewLifecycleOwner){
                it?.let{
                    setupUI(it)
                }
            }
        }
    }

    private fun setupUI(fruits: ArrayList<FruityViceItemModel>) {
        binding.rvFruits.adapter = fruitsAdapter
        fruitsAdapter.submitList(fruits)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemListenerFruitDetails(currentItem: FruityViceItemModel) {

        val action=FruitsFragmentDirections.actionFruitsFragmentToDetailsFragment(currentItem)
        findNavController().navigate(action)
    }

}