package com.example.doordash1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doordash1.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        const val BASE_URL = "https://api.doordash.com/"
        const val TAG = "MainActivity"
    }

    lateinit var binding: ActivityMainBinding
    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stores = mutableListOf<Store>()
        val adapter = StoresAdapter(this, stores)
        binding.rvStores.adapter = adapter
        binding.rvStores.layoutManager = LinearLayoutManager(this)

        (applicationContext as MyApplication).appComponent.inject(this)
        viewModel.getStores().observe(this, Observer {
            Log.d(TAG, "Observer received ${it!!.size} stores")
            stores.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}