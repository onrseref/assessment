package com.onurseref.marvel.base.di.module

import com.onurseref.marvel.ui.main.MainActivity
import com.onurseref.marvel.ui.main.module.MainActivityModule
import com.onurseref.marvel.ui.news.NewsActivity
import com.onurseref.marvel.ui.news.module.NewsActivityModule
import com.onurseref.marvel.ui.scores.ScoresActivity
import com.onurseref.marvel.ui.scores.module.ScoresActivityModule
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

}