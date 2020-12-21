package com.example.docsappassignment.chat.multiviewadapter

import android.view.View
import com.example.docsappassignment.chat.multiviewadapter.BaseViewHolder
import com.example.docsappassignment.chat.multiviewadapter.ChatDataModel

interface ViewModelTypeFactory {

    fun type(dataModel: ChatDataModel) : Int
    fun create(parent: View, viewType: Int) : BaseViewHolder<ChatDataModel>
}