package com.onurseref.mackolik.ui.news.module

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.onurseref.mackolik.ui.news.adapter.NewsAdapter
import dagger.Module
import dagger.Provides

@Module
class NewsActivityModule {

    @Provides
    fun provideNewsAdapter(): NewsAdapter =
        NewsAdapter()

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager =
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}