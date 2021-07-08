package com.ziesapp.kuesionerin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ziesapp.kuesionerin.data.Item
import com.ziesapp.kuesionerin.databinding.ItemListBinding

class ItemAdapter(private val dataset: ArrayList<Item>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemListBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Item) {
            with(binding){
                tvTitle.text = item.title
                tvDesc.text = item.description
                tvLink.text = item.link
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding
            .inflate(LayoutInflater.from(
                parent.context
            ),parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size

}