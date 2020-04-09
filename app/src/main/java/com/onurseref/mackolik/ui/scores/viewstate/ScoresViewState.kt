package com.onurseref.mackolik.ui.scores.viewstate

import com.onurseref.mackolik.common.models.ScoresResponse


sealed class ScoresViewState {
    object Loading : ScoresViewState()
    data class Error(val throwable: String) :
        ScoresViewState()

    data class Success(val scoresResponse: ScoresResponse?) :
        ScoresViewState()
}
