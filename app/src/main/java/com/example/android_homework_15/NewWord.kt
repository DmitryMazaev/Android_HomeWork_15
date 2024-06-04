package com.example.android_homework_15

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class NewWord(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "word")
    val oneWord: String
)
