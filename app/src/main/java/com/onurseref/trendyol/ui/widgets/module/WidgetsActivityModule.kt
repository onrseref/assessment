package com.onurseref.trendyol.ui.widgets.module

import com.onurseref.trendyol.di.ViewModelKey
import com.onurseref.trendyol.ui.widgets.viewmodel.WidgetsViewModel
import dagger.Module

@Module
abstract class WidgetsActivityModule {
    @ViewModelKey(WidgetsViewModel::class)
    internal abstract fun provideWidgetsViewModel(viewModel: WidgetsViewModel): WidgetsViewModel
}