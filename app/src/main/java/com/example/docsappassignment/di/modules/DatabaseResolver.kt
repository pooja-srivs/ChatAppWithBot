package com.example.docsappassignment.di.modules

import androidx.room.Room
import com.example.docsappassignment.MyApp
import com.example.docsappassignment.data.database.AppDatabase
import com.example.docsappassignment.data.database.QueryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseResolver() {

    @Provides
    @Singleton
    fun providesAppDatabse(application: MyApp) : AppDatabase = Room.
                                                             databaseBuilder(application, AppDatabase::class.java, "my-chat-data")
                                                            .allowMainThreadQueries()
                                                            .build()


    @Provides
    @Singleton
    fun providesRoomModule(appDatabase: AppDatabase) : QueryDao = appDatabase.queryDao()

}