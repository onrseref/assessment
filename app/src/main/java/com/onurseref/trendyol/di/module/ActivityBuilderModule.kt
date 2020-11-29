package com.onurseref.trendyol.di.module

import com.onurseref.trendyol.ui.detail.module.CharacterActivityModule
import com.onurseref.trendyol.ui.detail.view.CharacterActivity
import com.onurseref.trendyol.ui.widgets.module.WidgetsActivityModule
import com.onurseref.trendyol.ui.widgets.view.WidgetsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [WidgetsActivityModule::class])
    abstract fun bindCharactersActivity(): WidgetsActivity

    @ContributesAndroidInjector(modules = [CharacterActivityModule::class])
    abstract fun bindCharacterActivity(): CharacterActivity
}