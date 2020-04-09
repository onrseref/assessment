package com.onurseref.mackolik.ui.scores.domain

import com.onurseref.mackolik.common.extensions.isNotNull
import com.onurseref.mackolik.common.models.ScoresResponse
import com.onurseref.mackolik.data.service.Repository
import com.onurseref.mackolik.ui.scores.viewstate.ScoresViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ScoresUseCase @Inject constructor(private val repository: Repository) {

    fun getScores(): Observable<ScoresViewState> =
        repository.getScores()
            .subscribeOn(Schedulers.io())
            .map { getSuccessViewState(it) }
            .onErrorReturn { getFailViewState(it) }
            .startWith(ScoresViewState.Loading)

    private fun getSuccessViewState(it: ScoresResponse): ScoresViewState {
        return if (it.isNotNull()) {
            ScoresViewState.Success(it)
        } else {
            ScoresViewState.Error("Genel hata")
        }
    }

    private fun getFailViewState(throwable: Throwable): ScoresViewState {
        return ScoresViewState.Error(throwable.localizedMessage)
    }
}