package com.example.doordash1

import java.io.Serializable

data class Stores(val num_results: Int, val next_offset: Int, val stores: List<Store>)

data class Store(
    val delivery_fee: Float,
    val num_ratings: Int,
    val id: Int,
    val menus: List<Menu>,
    val average_rating: Float,
    val location: LatLng,
    val status: Status,
    val display_delivery_fee: String,
    val description: String,
    val business_id: Long,
    val cover_img_url: String,
    val header_img_url: String,
    val price_range: Int,
    val name: String,
    val url: String,
    val next_close_time: String,
    val next_open_time: String,
    val distance_from_consumer: Float
): Serializable {
    override fun toString(): String {
        return "Store(name='$name', description='$description', num_ratings=$num_ratings, cover_img_url='$cover_img_url', header_img_url='$header_img_url', url='$url')"
    }
}

data class Menu(val popular_items: List<PopularItem>, val id: Long): Serializable

data class PopularItem(val price: Int, val img_url: String, val description: String, val name: String, val id: Long): Serializable {
    override fun toString(): String {
        return "price: $price, description: $description, name: $name"
    }
}

data class LatLng(val lat: String, val lng: String): Serializable

data class Status(val asap_minutes_range: List<Int>): Serializable
