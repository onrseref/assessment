package com.onurseref.mackolik.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.onurseref.mackolik.base.ui.BaseViewModel
import com.onurseref.mackolik.common.models.NewsResponse


/**
 * Created by Onur Şeref on 9.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */
class MainViewModel : BaseViewModel() {

    val isLoadingLiveData = MutableLiveData<Boolean>()
    val errorMessageLiveData = MutableLiveData<String>()
/*
    fun getNews() {
        newsUseCase.getNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is NewsViewState.Loading -> {
                        isLoadingLiveData.value = true
                    }
                    is NewsViewState.Success -> {
                        isLoadingLiveData.value = false
                        newsLiveData.value = it.newsResponse
                    }
                    else -> {
                        isLoadingLiveData.value = false
                        errorMessageLiveData.value = (it as NewsViewState.Error).throwable
                    }
                }
            }
            .also { disposable += it }
    }*/
}