package com.example.doordash1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doordash1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        const val BASE_URL = "https://api.doordash.com/"
        const val TAG = "MainActivity"
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stores = mutableListOf<Store>()
        val adapter = StoresAdapter(this, stores)
        binding.rvStores.adapter = adapter
        binding.rvStores.layoutManager = LinearLayoutManager(this)

        val doorDashService = Network.retrofit.create(DoorDashService::class.java)
        doorDashService.getStores(lat=37.374410f, lng=-121.872600f).enqueue(object: Callback<Stores> {
            override fun onResponse(call: Call<Stores>, response: Response<Stores>) {
                Log.d(TAG, "onResponse $response")
                val body = response.body()
                if (body == null) {
                    Log.w(TAG, "Did not receive a valid response from DoorDash API... exiting")
                } else {
                    stores.addAll(body.stores)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Stores>, t: Throwable) {
                Log.d(TAG, "onFailure $t")
            }
        })
    }
}