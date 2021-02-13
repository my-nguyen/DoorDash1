package com.example.doordash1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.doordash1.databinding.ItemStoreBinding

class StoresAdapter(private val context: Context, private val stores: List<Store>): RecyclerView.Adapter<StoresAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemStoreBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(store: Store) {
            val roundedCorners = RequestOptions().transform(CenterCrop(), RoundedCorners(20))
            val url = if (store.header_img_url.isNotEmpty()) store.header_img_url else store.cover_img_url
            Glide.with(context).load(url).apply(roundedCorners).into(binding.ivFood)
            binding.tvName.text = store.name
            val dollars = "$".repeat(store.price_range)
            binding.tvDescription.text = "$dollars . ${store.description}"
            // binding.tvStars.text =
            binding.tvRatings.text = "${store.num_ratings} ratings"
            binding.tvHowFar.text = "${store.status.asap_minutes_range[0]} min"
            binding.tvIsFreeDelivery.text = store.display_delivery_fee
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemStoreBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores[position]
        holder.bind(store)
    }

    override fun getItemCount() = stores.size
}
