package com.onurseref.marvel.base.di.module

import android.content.Context
import com.onurseref.marvel.App
import dagger.Module
import dagger.Provides


@Module(includes = [NetworkModule::class])
class ApplicationModule {

    @Provides
    fun provideContext(application: App): Context = application.applicationContext
}
