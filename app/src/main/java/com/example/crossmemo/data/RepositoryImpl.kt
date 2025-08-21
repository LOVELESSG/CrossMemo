//package com.example.crossmemo.data
//
//import com.example.crossmemo.data.memo.Memo
//import com.example.crossmemo.data.memo.MemoDao
//import javax.inject.Inject
//import javax.inject.Singleton
//
//@Singleton
//class RepositoryImpl @Inject constructor(private val memeDao: MemoDao): Repository{
//
//    override val allMemo = memeDao.loadAllMemo()
//
//    override suspend fun insertMemo(memo: Memo) {
//        memeDao.insertMemo(memo)
//    }
//
//    override suspend fun deleteMemo(memo: Memo) {
//        memeDao.deleteMemo(memo)
//    }
//
//    override suspend fun updateMemo(memo: Memo) {
//        memeDao.updateMemo(memo)
//    }
//}