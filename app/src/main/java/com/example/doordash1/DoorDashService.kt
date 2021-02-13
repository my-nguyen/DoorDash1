package com.example.doordash1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DoorDashService {
    @GET("v1/store_feed/?lat=37.422740&lng=-122.139956&offset=0&limit=50")
    fun listRestaurants(@Query("lat") lat: Float=37.422740f,
                        @Query("lng") lng: Float=-122.139956f,
                        @Query("offset") offset: Int=0,
                        @Query("limit") limit: Int=50
    ): Call<Restaurants>
}