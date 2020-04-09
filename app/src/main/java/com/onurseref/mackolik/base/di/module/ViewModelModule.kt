package com.onurseref.mackolik.base.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onurseref.mackolik.ui.news.viewmodel.NewsViewModel
import com.onurseref.mackolik.base.di.factory.ViewModelFactory
import com.onurseref.mackolik.base.di.factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule{

    @IntoMap
    @Binds
    @ViewModelKey(NewsViewModel::class)
    abstract fun provideMainViewModel(newsViewModel: NewsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}