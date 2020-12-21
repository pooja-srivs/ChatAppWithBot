package com.mingle.chatapp.movie.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.docsappassignment.chat.ChatViewModel
import com.example.docsappassignment.data.repository.DataRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModelFactory @Inject constructor(private val movieDataRepository : DataRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChatViewModel(movieDataRepository) as T
    }
}