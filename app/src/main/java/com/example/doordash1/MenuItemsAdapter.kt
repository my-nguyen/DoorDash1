package com.example.doordash1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doordash1.databinding.ItemMenuItemBinding

class MenuItemsAdapter(val context: Context, private val menuItems: List<PopularItem>): RecyclerView.Adapter<MenuItemsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem: PopularItem) {
            binding.tvName.text = menuItem.name
            binding.tvDescription.text = menuItem.description
            binding.tvPrice.text = "$%.2f".format(menuItem.price / 100f)
            Glide.with(context).load(menuItem.img_url).into(binding.ivPicture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemMenuItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuItems[position]
        holder.bind(menuItem)
    }

    override fun getItemCount() = menuItems.size
}