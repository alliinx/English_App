package com.example.english_app.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.english_app.data.database.WordDao
import com.example.english_app.data.database.WordDatabase
import com.example.english_app.data.model.WordEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class WordRepository (
    context: Context,
    private val backgroundDispatcher: CoroutineDispatcher){

    private val wordDao: WordDao

    init {
        val database = WordDatabase.getInstance(context, backgroundDispatcher)
        wordDao = database!!.wordDao()
    }

    suspend fun  insert(word: WordEntity){
        withContext(backgroundDispatcher) {
            wordDao.insertWord(word)
        }
    }
    suspend fun  update(word: WordEntity){
        withContext(backgroundDispatcher) {
            wordDao.updateWord(word)
        }
    }
    suspend fun  delete(word: WordEntity){
        withContext(backgroundDispatcher) {
            wordDao.deleteWord(word)
        }
    }

    fun getAllWords(): LiveData<List<WordEntity>> {
        return wordDao.getWords()
    }
}
