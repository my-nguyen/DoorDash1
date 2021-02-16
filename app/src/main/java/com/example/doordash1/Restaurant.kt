package com.example.doordash1

import java.io.Serializable

data class Restaurant(
    val phone_number: String,
    val yelp_review_count: Int,
    val offers_delivery: Boolean,
    val id: Long,
    val average_rating: Float,
    val tags: List<String>,
    val menus: List<Menu2>,
    val number_of_ratings: Int,
    val description: String,
    val yelp_biz_id: String,
    val yelp_rating: Float,
    val business_id: Long,
    val cover_img_url: String,
    val address: Address,
    val price_range: Int,
    val name: String,
): Serializable

data class Menu2(val subtitle: String, val name: String, val open_hours: List<List<OpenHour>>, val id: Long): Serializable

data class OpenHour(val hour: Int, val minute: Int): Serializable

data class Address(
    val city: String,
    val id: Long,
    val printable_address: String,
    val state: String,
    val street: String,
    val country: String,
    val lat: Float,
    val lng: Float,
    val zip_code: String
): Serializable