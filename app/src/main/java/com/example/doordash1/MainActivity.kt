package com.example.doordash1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
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

        val model: MainViewModel by viewModels()
        model.getStores().observe(this, Observer {
            stores.addAll(it!!)
            adapter.notifyDataSetChanged()
        })
    }
}