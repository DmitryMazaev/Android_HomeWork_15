package com.example.android_homework_15

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {
    @Query("SELECT * FROM Words")
    fun getAllWords(): Flow<List<Word>>

    @Insert(entity = Word::class)
    fun insertWord(word: NewWord)

    @Delete
    fun delete(word: Word)

    @Update
    fun update(word: Word)
}