package com.example.english_app.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val word: String,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val meaning: String,
    val image: String
)