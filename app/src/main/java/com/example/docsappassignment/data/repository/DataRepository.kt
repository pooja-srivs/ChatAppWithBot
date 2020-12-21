package com.example.docsappassignment.data.repository

import com.example.docsappassignment.data.database.QueryDao
import com.example.docsappassignment.data.database.ChatData
import com.example.docsappassignment.data.remote.sources.DataSource
import com.example.docsappassignment.data.remote.sources.ChatDataModel
import io.reactivex.Single

class DataRepository(
    private val dataSource: DataSource,
    private val dao: QueryDao,
    private val apiKey: String
    ) {
    fun getNearbyPlaceData(message : String) : Single<ChatDataModel> {
        return dataSource.getSearchData(apiKey, message, "63906", "pooja")
    }

    fun getAllChatDataPlacesData() : List<ChatData> {
        return dao.getRecentPlaces()
    }

    fun insertOrUpdate(ChatData: ChatData) {
        val itemFromDB: ChatData
        itemFromDB = dao.getItemById(ChatData.message)

        if (itemFromDB == null){
            dao.insertRecentPlace(ChatData)
        }else{
            dao.updateItem(ChatData.message)
        }
    }


}