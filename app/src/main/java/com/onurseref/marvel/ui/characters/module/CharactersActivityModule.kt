package com.onurseref.marvel.ui.characters.module

import com.onurseref.marvel.base.di.ViewModelKey
import com.onurseref.marvel.ui.characters.viewmodel.CharactersViewModel
import dagger.Module

@Module
abstract class CharactersActivityModule {
    @ViewModelKey(CharactersViewModel::class)
    internal abstract fun provideCharactersViewModel(viewModel: CharactersViewModel): CharactersViewModel
}