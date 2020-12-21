package com.example.docsappassignment.di.modules

import com.example.docsappassignment.chat.ChatActivity
import com.example.docsappassignment.chat.di.DataModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(DataModule::class))
    abstract fun providesMainActivity() : ChatActivity
}