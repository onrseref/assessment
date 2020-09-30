package com.onurseref.marvel.ui.main.module

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides


/**
 * Created by Onur Şeref on 9.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */
@Module
class MainActivityModule {

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager =
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}