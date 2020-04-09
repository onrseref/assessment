package com.onurseref.mackolik.base.di.module

import com.onurseref.mackolik.ui.inappbrowser.InAppBrowserActivity
import com.onurseref.mackolik.ui.main.MainActivity
import com.onurseref.mackolik.ui.main.module.InAppBrowserActivityModule
import com.onurseref.mackolik.ui.main.module.MainActivityModule
import com.onurseref.mackolik.ui.news.NewsActivity
import com.onurseref.mackolik.ui.news.module.NewsActivityModule
import com.onurseref.mackolik.ui.scores.ScoresActivity
import com.onurseref.mackolik.ui.scores.module.ScoresActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [NewsActivityModule::class])
    abstract fun bindNewsActivity(): NewsActivity

    @ContributesAndroidInjector(modules = [ScoresActivityModule::class])
    abstract fun bindScoresActivity(): ScoresActivity

    @ContributesAndroidInjector(modules = [InAppBrowserActivityModule::class])
    abstract fun bindInAppBrowserActivity(): InAppBrowserActivity

}