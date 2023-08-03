package com.example.english_app.presentation.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.english_app.data.repository.WordRepository

class WordViewModelFactory(
    private val repository: WordRepository,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WordViewModel(repository, context) as T
    }
}