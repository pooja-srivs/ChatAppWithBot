package com.example.docsappassignment.di.modules

import com.example.docsappassignment.data.database.QueryDao
import com.mingle.chatapp.data.remote.config.ApiManager
import com.example.docsappassignment.data.remote.sources.DataSource
import com.example.docsappassignment.data.repository.DataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceResolver {

    @Singleton
    @Provides
    fun providesMovieSource(apiManager: ApiManager) : DataSource = DataSource(apiManager.dataService)

    @Singleton
    @Provides
    fun providesMovieDataRepository(movieSource: DataSource, dao: QueryDao, apiKey : String) : DataRepository = DataRepository(movieSource,
                                                                                                                                    dao,
                                                                                                                                    apiKey)
}