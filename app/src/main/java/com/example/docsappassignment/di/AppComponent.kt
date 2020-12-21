package com.example.docsappassignment.di

import com.example.docsappassignment.MyApp
import com.example.docsappassignment.di.modules.ActivityResolver
import com.example.docsappassignment.di.modules.DataSourceResolver
import com.example.docsappassignment.di.modules.DatabaseResolver
import com.example.docsappassignment.di.modules.NetworkResolver
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ActivityResolver::class,
    DataSourceResolver::class,
    NetworkResolver::class,
    DatabaseResolver::class))
interface AppComponent : AndroidInjector<MyApp>{

    override fun inject(myApp: MyApp)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(myApp: MyApp): Builder

        fun build(): AppComponent
    }

}