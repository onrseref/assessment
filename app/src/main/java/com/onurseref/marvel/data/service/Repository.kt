package com.onurseref.marvel.data.service

import com.onurseref.marvel.common.models.NewsResponse
import com.onurseref.marvel.common.models.ScoresResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    fun getNews(): Observable<NewsResponse> = remoteDataSource
        .getNews()
        .subscribeOn(Schedulers.io())

    fun getScores(): Observable<ScoresResponse> = remoteDataSource
        .getScores()
        .subscribeOn(Schedulers.io())
}