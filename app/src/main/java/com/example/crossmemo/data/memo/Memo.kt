package com.example.crossmemo.data.memo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    val title: String,
    val content: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long
)