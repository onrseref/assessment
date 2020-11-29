package com.onurseref.trendyol.ui.widgets.domain

import com.onurseref.trendyol.common.extension.isNotNull
import com.onurseref.trendyol.data.Repository
import com.onurseref.trendyol.ui.widgets.model.WidgetsResponse
import com.onurseref.trendyol.ui.widgets.viewstate.WidgetsViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WidgetsUseCase @Inject constructor(private val repository: Repository) {

    fun getWidgets(): Observable<WidgetsViewState> =
        repository.getWidgets()
            .subscribeOn(Schedulers.io())
            .map { getSuccessViewState(it) }
            .onErrorReturn { getFailViewState(it) }
            .startWith(WidgetsViewState.Loading)

    private fun getSuccessViewState(it: WidgetsResponse): WidgetsViewState {
        return if (it.isNotNull()) {
            WidgetsViewState.Success(it)
        } else {
            WidgetsViewState.Error("Genel hata")
        }
    }

    private fun getFailViewState(throwable: Throwable): WidgetsViewState {
        return WidgetsViewState.Error(throwable.localizedMessage!!)
    }
}