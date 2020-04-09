package com.onurseref.mackolik.ui.news.domain

import com.onurseref.mackolik.common.extensions.isNotNull
import com.onurseref.mackolik.common.models.NewsResponse
import com.onurseref.mackolik.data.service.Repository
import com.onurseref.mackolik.ui.news.viewstate.NewsViewState
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
        return NewsViewState.Error(throwable.localizedMessage)
    }
}