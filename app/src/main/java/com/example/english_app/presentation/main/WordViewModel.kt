package com.example.english_app.presentation.main

import android.content.Context
import androidx.lifecycle.*
import com.example.english_app.data.database.WordDatabase
import com.example.english_app.data.model.WordEntity
import com.example.english_app.data.repository.WordRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData


class WordViewModel(private val wordRepository: WordRepository,context: Context) :
        ViewModel() {

       // private val _dataLoading = MutableLiveData<Boolean>()
        //val dataLoading: LiveData<Boolean> = _dataLoading

        init {
            for (word in WordDatabase.getPrepopulateData(context)) {
                viewModelScope.launch {
                    wordRepository.insert(word)
                }
            }
        }

        fun getWords():  LiveData<List<WordEntity>>{
            return wordRepository.getAllWords()
        }
        //val words: LiveData<List<WordEntity>> = wordRepository.getAllWords()

        fun insertWord(word: WordEntity) {
            //showProgress()
            viewModelScope.launch {
                wordRepository.insert(word)
            }
            //hideProgress()
        }

        fun updateWord(word: WordEntity) {
            //showProgress()
            viewModelScope.launch {
                wordRepository.update(word)
            }
            //hideProgress()
        }

        fun deleteWord(word: WordEntity) {
            //showProgress()
            viewModelScope.launch {
                wordRepository.delete(word)
            }
            //hideProgress()
        }

//        fun getAllWords(): LiveData<List<WordEntity>> {
//            val words: LiveData<List<WordEntity>>?
//            _dataLoading.value = true
//            words = wordRepository.getAllWords()
//            _dataLoading.value = false
//            return words
//        }
//
//        private fun showProgress() {
//            _dataLoading.value = true
//        }
//
//        private fun hideProgress() {
//            _dataLoading.value = false
//        }
}