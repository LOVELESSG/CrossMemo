package com.example.crossmemo.data.memo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Insert
    suspend fun insertMemo(memo: Memo): Long

    @Update
    suspend fun updateMemo(memo: Memo)

    @Query("select * from Memo")
    fun loadAllMemo(): Flow<List<Memo>>

    @Delete
    suspend fun deleteMemo(memo: Memo)
}