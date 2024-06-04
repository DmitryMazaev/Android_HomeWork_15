package com.example.android_homework_15

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun wordsDao(): WordsDao
}