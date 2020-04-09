package com.onurseref.mackolik.ui.scores.viewmodel

import androidx.lifecycle.MutableLiveData
import com.onurseref.mackolik.base.ui.BaseViewModel
import com.onurseref.mackolik.common.models.ScoresResponse
import com.onurseref.mackolik.ui.scores.domain.ScoresUseCase
import com.onurseref.mackolik.ui.scores.viewstate.ScoresViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class ScoresViewModel @Inject constructor(private val scoresUseCase: ScoresUseCase) :
    BaseViewModel() {

    val scoresResponse = MutableLiveData<ScoresResponse?>()
    val isLoadingLiveData = MutableLiveData<Boolean>()
    val errorMessageLiveData = MutableLiveData<String>()

    fun getScores() {
        scoresUseCase.getScores()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is ScoresViewState.Loading -> {
                        isLoadingLiveData.value = true
                    }
                    is ScoresViewState.Success -> {
                        isLoadingLiveData.value = false
                        scoresResponse.value = it.scoresResponse
                    }
                    else -> {
                        isLoadingLiveData.value = false
                        errorMessageLiveData.value = (it as ScoresViewState.Error).throwable
                    }
                }
            }
            .also { disposable += it }
    }
}