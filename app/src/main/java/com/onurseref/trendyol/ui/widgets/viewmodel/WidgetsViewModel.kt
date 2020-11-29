package com.onurseref.trendyol.ui.widgets.viewmodel

import androidx.lifecycle.MutableLiveData
import com.onurseref.trendyol.base.BaseViewModel
import com.onurseref.trendyol.common.extension.isNotNull
import com.onurseref.trendyol.ui.widgets.domain.WidgetsUseCase
import com.onurseref.trendyol.ui.widgets.model.Widget
import com.onurseref.trendyol.ui.widgets.viewstate.WidgetsViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class WidgetsViewModel @Inject constructor(private val widgetsUseCase: WidgetsUseCase) :
    BaseViewModel() {

    val widgetListLiveData = MutableLiveData<ArrayList<Widget>?>()
    val isLoadingLiveData = MutableLiveData<Boolean>()

    fun getWidgets() {
        widgetsUseCase.getWidgets()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is WidgetsViewState.Loading -> {
                        isLoadingLiveData.postValue(true)
                    }
                    is WidgetsViewState.Success -> {
                        isLoadingLiveData.postValue(false)

                        if (it.widgetsResponse?.widgets.isNotNull()) {
                            widgetListLiveData.postValue(it.widgetsResponse?.widgets as ArrayList<Widget>)
                        }
                    }
                    else -> {
                        isLoadingLiveData.postValue(false)
                    }
                }
            }
            .also { disposable += it }
    }
}