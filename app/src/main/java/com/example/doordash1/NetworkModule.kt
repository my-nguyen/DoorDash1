package com.example.doordash1

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetroService(): DoorDashService {
        return Retrofit.Builder()
            .baseUrl("https://api.doordash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DoorDashService::class.java)
    }
}