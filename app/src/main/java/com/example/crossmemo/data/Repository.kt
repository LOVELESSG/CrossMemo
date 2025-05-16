package com.example.crossmemo.data

import com.example.crossmemo.data.memo.Memo
import kotlinx.coroutines.flow.Flow

interface Repository {
    val allMemo: Flow<List<Memo>>
    suspend fun insertMemo(memo: Memo)
    suspend fun updateMemo(memo: Memo)
    suspend fun deleteMemo(memo: Memo)
}