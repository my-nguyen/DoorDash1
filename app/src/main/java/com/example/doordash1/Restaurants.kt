package com.example.doordash1

data class Restaurants(val num_results: Int, val next_offset: Int, val stores: List<Store>)

data class Store(
    val delivery_fee: Float,
    val num_ratings: Int,
    val id: Long,
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
    val next_open_time: String

) {
    override fun toString(): String {
        return "Store(name='$name', description='$description', num_ratings=$num_ratings, cover_img_url='$cover_img_url', header_img_url='$header_img_url', url='$url')"
    }
}

data class Menu(val popular_items: List<PopularItem>, val id: Long)

data class PopularItem(val price: Int, val img_url: String, val description: String, val name: String, val id: Long)

data class LatLng(val lat: String, val lng: String)

data class Status(val asap_minutes_range: List<Int>)
