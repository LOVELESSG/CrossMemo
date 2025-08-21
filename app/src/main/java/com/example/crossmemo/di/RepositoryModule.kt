//package com.example.crossmemo.di
//
//import com.example.crossmemo.data.Repository
//import com.example.crossmemo.data.RepositoryImpl
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModule {
//    @Binds
//    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository
//}

package com.example.crossmemo.di

import android.content.Context
import androidx.room.Room
import com.example.crossmemo.data.AppDatabase
import com.example.crossmemo.data.memo.MemoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "cross_memo_db" // Ensure this matches your AppDatabase companion object name
        ).build()
    }

    @Provides
    @Singleton // DAOs are often singletons if the Database is a singleton
    fun provideMemoDao(appDatabase: AppDatabase): MemoDao {
        return appDatabase.memoDao()
    }
}
