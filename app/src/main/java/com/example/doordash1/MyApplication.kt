package com.example.doordash1

import android.app.Application

class MyApplication: Application() {
    val appComponent = DaggerApplicationComponent.create()
}