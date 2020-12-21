package com.example.docsappassignment.data.remote.sources

import io.reactivex.Single

class DataSource(val dataService: DataService) {

    fun getSearchData(apiKey : String, message : String, botId : String, externalId : String): Single<ChatDataModel> {
        return dataService.getSearchData(apiKey, message, botId, externalId)
    }
}