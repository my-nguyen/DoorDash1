package com.example.doordash1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    const val TAG = "Repository"

    val doorDashService = Network.doorDash()

    fun getStores(): MutableLiveData<List<Store>> {
        val stores = MutableLiveData<List<Store>>()
        doorDashService.getStores().enqueue(object: Callback<Stores> {
            override fun onResponse(call: Call<Stores>, response: Response<Stores>) {
                Log.d(TAG, "onResponse $response")
                val body = response.body()
                if (body == null) {
                    Log.w(TAG, "Did not receive a valid response from DoorDash API... exiting")
                } else {
                    stores.value = body.stores
                }
            }

            override fun onFailure(call: Call<Stores>, t: Throwable) {
                Log.d(TAG, "onFailure $t")
            }
        })
        return stores
    }
}