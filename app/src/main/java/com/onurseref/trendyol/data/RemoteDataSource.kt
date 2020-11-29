package com.onurseref.trendyol.data

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: Service) {

    fun getWidgets() =
        service.getWidgets("application/json", "85")
}