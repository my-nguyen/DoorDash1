package com.example.doordash1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var stores: MutableLiveData<List<Store>> = Repository.getStores()

    fun getStores(): LiveData<List<Store>> = stores

    fun getRestaurant(id: Int) = Repository.getRestaurant(id)
}