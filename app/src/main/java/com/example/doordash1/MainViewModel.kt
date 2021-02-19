package com.example.doordash1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private var stores: MutableLiveData<List<Store>> = repository.getStores()

    fun getStores(): LiveData<List<Store>> = stores

    fun getRestaurant(id: Int) = repository.getRestaurant(id)
}