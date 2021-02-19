package com.example.doordash1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.doordash1.databinding.ActivityStoreBinding
import javax.inject.Inject

class RestaurantActivity : AppCompatActivity() {

    companion object {
        const val TAG = "StoreActivity"
    }

    lateinit var binding: ActivityStoreBinding
    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_restaurant)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val store = intent.getSerializableExtra("EXTRA_STORE") as Store

        (applicationContext as MyApplication).appComponent.inject(this)
        viewModel.getRestaurant(store.id).observe(this, Observer { restaurant ->
            val roundedCorners = RequestOptions().transform(CenterCrop(), RoundedCorners(20))
            val url = if (store.header_img_url.isNotEmpty()) store.header_img_url else store.cover_img_url
            Glide.with(this).load(url).apply(roundedCorners).into(binding.ivPicture)
            binding.tvName.text = store.name
            val splits = store.description.split(", ")
            binding.tvDescription.text = "${splits[0]} - ${splits[1]}"
            binding.tvStars.text = restaurant.average_rating.toString()
            binding.tvRatings.text = "${restaurant.number_of_ratings} ratings"
            binding.tvDistance.text = "- %.1f mi".format(store.distance_from_consumer)
            val dollars = "$".repeat(restaurant.price_range)
            binding.tvPriceRange.text = "- $dollars"

            binding.tvDeliverFeeAmount.text = "$%.2f".format(store.delivery_fee)
            binding.tvDeliveryFeeLabel.text = "delivery fee"
            binding.tvDeliveryTimeAmount.text = "${store.status.asap_minutes_range[0].toString()} min"
            binding.tvDeliveryTimeLabel.text = "delivery time"

            val adapter = MenuItemsAdapter(this, store.menus[0].popular_items)
            binding.rvMenu.adapter = adapter
            val layoutManager = LinearLayoutManager(this)
            binding.rvMenu.layoutManager = layoutManager
            val decor = DividerItemDecoration(this, layoutManager.orientation)
            binding.rvMenu.addItemDecoration(decor)
        })
    }
}