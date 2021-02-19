package com.example.doordash1

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: RestaurantActivity)
}