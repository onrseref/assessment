package com.onurseref.trendyol.ui.widgets.viewstate

import com.onurseref.trendyol.ui.widgets.model.WidgetsResponse


sealed class WidgetsViewState {
    object Loading : WidgetsViewState()
    data class Error(val throwable: String) :
        WidgetsViewState()

    data class Success(val widgetsResponse: WidgetsResponse?) :
        WidgetsViewState()
}
