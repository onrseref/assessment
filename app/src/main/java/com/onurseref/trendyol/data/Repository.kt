package com.onurseref.trendyol.data

import com.onurseref.trendyol.ui.widgets.model.WidgetsResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    fun getWidgets(): Observable<WidgetsResponse> = remoteDataSource
        .getWidgets()
        .subscribeOn(Schedulers.io())
}