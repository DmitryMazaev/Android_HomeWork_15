package com.example.android_homework_15

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val wordsDao: WordsDao): ViewModel() {
    val allWords: Flow<List<Word>> = this.wordsDao.getAllWords()

    fun addWord(string: String) {
        viewModelScope.launch {
            wordsDao.insertWord(
                NewWord(
                    oneWord = string
                )
            )
        }
    }
}