package com.example.crossmemo.data.repository

import com.example.crossmemo.data.memo.Memo
import com.example.crossmemo.data.memo.MemoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton // If using Hilt, make it a singleton
class MemoRepository @Inject constructor(private val memoDao: MemoDao) {
// For now, without Hilt, you might instantiate it directly or provide it manually.
// class MemoRepository(private val memoDao: MemoDao) {

    suspend fun insertMemo(memo: Memo): Long {
        return memoDao.insertMemo(memo)
    }

    suspend fun updateMemo(memo: Memo) {
        memoDao.updateMemo(memo)
    }

    fun getAllMemos(): Flow<List<Memo>> {
        return memoDao.loadAllMemo()
    }

    suspend fun deleteMemo(memo: Memo) {
        memoDao.deleteMemo(memo)
    }

    // You can add other methods here if needed, e.g., getMemoById
}
