package com.example.english_app.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.english_app.data.model.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM words")
    fun getWords(): LiveData<List<WordEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: WordEntity): Long

    @Update
    suspend fun  updateWord(word: WordEntity): Int

    @Delete
    suspend fun deleteWord(word: WordEntity): Int
}