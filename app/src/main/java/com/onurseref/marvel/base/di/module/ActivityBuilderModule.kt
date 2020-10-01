package com.onurseref.marvel.base.di.module

import com.onurseref.marvel.ui.characters.CharactersActivity
import com.onurseref.marvel.ui.characters.module.CharactersActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [CharactersActivityModule::class])
    abstract fun bindCharactersActivity(): CharactersActivity
}