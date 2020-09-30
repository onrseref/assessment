package com.onurseref.marvel.ui.news.domain

import com.onurseref.marvel.common.extension.isNotNull
import com.onurseref.marvel.common.models.NewsResponse
import com.onurseref.marvel.data.service.Repository
import com.onurseref.marvel.ui.news.viewstate.NewsViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repository: Repository) {

    fun getNews(): Observable<NewsViewState> =
        repository.getNews()
            .subscribeOn(Schedulers.io())
            .map { getSuccessViewState(it) }
            .onErrorReturn { getFailViewState(it) }
            .startWith(NewsViewState.Loading)

    private fun getSuccessViewState(it: NewsResponse): NewsViewState {
        return if (it.isNotNull()) {
            NewsViewState.Success(it)
        } else {
            NewsViewState.Error("Genel hata")
        }
    }

    private fun getFailViewState(throwable: Throwable): NewsViewState {
        return NewsViewState.Error(throwable.localizedMessage!!)
    }
}