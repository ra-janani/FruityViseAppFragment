package com.example.fruityviseapp.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fruityviseapp.data.FruityViceItemModel
import com.example.fruityviseapp.R
import com.example.fruityviseapp.databinding.FruitsItemsBinding

class FruitAdapter(private val listener: ItemClickListener) :
    ListAdapter<FruityViceItemModel, FruitAdapter.ViewHolder>(
        diffCallback
    ) {
    class ViewHolder(private val binding: FruitsItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //@SuppressLint("SetTextI18n")
        fun bind(
            item: FruityViceItemModel,
            listener: ItemClickListener
        ) {
            binding.apply {
                tvName.text = binding.root.context.getString(R.string.name) + "${item.name}"
                tvFamily.text = "Family: ${item.family}"
                tvGenus.text = "Genus: ${item.genus}"
                tvOrder.text = "Order: ${item.order}"
                cvFruits.setOnClickListener {
                    listener.itemListenerFruitDetails(item)
                }

            }
        }
    }


    interface ItemClickListener {
        fun itemListenerFruitDetails(currentItem: FruityViceItemModel)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<FruityViceItemModel>() {
            override fun areItemsTheSame(
                oldItem: FruityViceItemModel,
                newItem: FruityViceItemModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: FruityViceItemModel,
                newItem: FruityViceItemModel
            ): Boolean {
                return (oldItem == newItem)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FruitsItemsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem: FruityViceItemModel = getItem(position)
        currentItem.let {
            holder.bind(it, listener)
        }
    }

}