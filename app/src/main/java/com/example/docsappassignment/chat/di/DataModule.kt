package com.example.docsappassignment.chat.di

import androidx.lifecycle.ViewModelProviders
import com.example.docsappassignment.chat.ChatActivity
import com.example.docsappassignment.chat.ChatViewModel
import com.example.docsappassignment.data.repository.DataRepository
import com.mingle.chatapp.movie.vmfactory.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesViewModelFactory(movieDataRepository: DataRepository) = MainViewModelFactory(movieDataRepository)

    @Provides
    fun providesMainViewModel(factory: MainViewModelFactory, activity: ChatActivity) : ChatViewModel = ViewModelProviders
        .of(activity, factory)
        .get(ChatViewModel::class.java)

  /*  @Provides
    fun provideVM(factory: MainViewModelFactory, activity: MainActivity): MainViewModel = ViewModelProvider(activity, factory).get(MainViewModel::class.java)
*/
}