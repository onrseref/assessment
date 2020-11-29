package com.onurseref.trendyol.di.module

import com.onurseref.trendyol.ui.detail.module.DetailActivityModule
import com.onurseref.trendyol.ui.detail.view.DetailActivity
import com.onurseref.trendyol.ui.widgets.module.WidgetsActivityModule
import com.onurseref.trendyol.ui.widgets.view.WidgetsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [WidgetsActivityModule::class])
    abstract fun bindCharactersActivity(): WidgetsActivity

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity
}