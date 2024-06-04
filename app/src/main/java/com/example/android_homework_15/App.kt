package com.example.android_homework_15

import android.app.Application
import androidx.room.Room

class App: Application() {
    lateinit var db: AppDatabase
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "data_base"
        ).build()
    }
}