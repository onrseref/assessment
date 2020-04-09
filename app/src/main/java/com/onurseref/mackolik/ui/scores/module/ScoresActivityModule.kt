package com.onurseref.mackolik.ui.scores.module

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.onurseref.mackolik.ui.scores.adapter.ScoresAdapter
import dagger.Module
import dagger.Provides

@Module
class ScoresActivityModule {

    @Provides
    fun provideScoresAdapter(): ScoresAdapter =
        ScoresAdapter()

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager =
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}