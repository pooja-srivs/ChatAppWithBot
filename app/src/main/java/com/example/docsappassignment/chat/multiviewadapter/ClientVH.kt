package com.example.docsappassignment.chat.multiviewadapter

import android.view.View
import com.example.docsappassignment.chat.multiviewadapter.BaseViewHolder
import com.example.docsappassignment.chat.multiviewadapter.ChatDataModel
import kotlinx.android.synthetic.main.item_messages.view.*

class ClientVH(view: View): BaseViewHolder<ChatDataModel>(view) {
    override fun bind(model: ChatDataModel) {

        with(itemView){
            tv_msg.text = model.message
        }
    }
}