package com.onurseref.mackolik.base.di.module

import com.onurseref.mackolik.ui.main.MainActivity
import com.onurseref.mackolik.ui.main.module.MainActivityModule
import com.onurseref.mackolik.ui.news.NewsActivity
import com.onurseref.mackolik.ui.news.module.NewsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [NewsActivityModule::class])
    abstract fun bindNewsActivity(): NewsActivity
}