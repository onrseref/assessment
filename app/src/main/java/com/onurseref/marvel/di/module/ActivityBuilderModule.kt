package com.onurseref.marvel.di.module

import com.onurseref.marvel.ui.character.module.CharacterActivityModule
import com.onurseref.marvel.ui.character.view.CharacterActivity
import com.onurseref.marvel.ui.characters.module.CharactersActivityModule
import com.onurseref.marvel.ui.characters.view.CharactersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [CharactersActivityModule::class])
    abstract fun bindCharactersActivity(): CharactersActivity

    @ContributesAndroidInjector(modules = [CharacterActivityModule::class])
    abstract fun bindCharacterActivity(): CharacterActivity
}