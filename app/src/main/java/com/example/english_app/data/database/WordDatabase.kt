package com.example.english_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.english_app.data.model.WordEntity
import com.example.english_app.data.network.DataToEntity
import kotlinx.coroutines.CoroutineDispatcher

const val DATABASE_VERSION_CODE = 1

@Database(entities = [WordEntity::class], version = DATABASE_VERSION_CODE, exportSchema = true)
abstract class WordDatabase (): RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context, backgroundDispatcher: CoroutineDispatcher): WordDatabase? {
            if (INSTANCE == null) {
                synchronized(WordDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        WordDatabase::class.java, "word_database"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun getPrepopulateData(context: Context):List<WordEntity>{
            return DataToEntity(context)
        }

    }
}