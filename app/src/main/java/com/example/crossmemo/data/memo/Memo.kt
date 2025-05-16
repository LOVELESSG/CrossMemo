package com.example.crossmemo.data.memo

import androidx.room.Entity

@Entity
data class Memo(
    val title: String,
    val content: String,
    val id: Int
)