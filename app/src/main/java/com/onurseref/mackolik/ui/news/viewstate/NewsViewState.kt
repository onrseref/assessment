package com.onurseref.mackolik.ui.news.viewstate

import com.onurseref.mackolik.common.models.NewsResponse


sealed class NewsViewState {
    object Loading: NewsViewState()
    data class Error(val throwable: String):
        NewsViewState()
    data class Success(val newsResponse: NewsResponse?):
        NewsViewState()
}
