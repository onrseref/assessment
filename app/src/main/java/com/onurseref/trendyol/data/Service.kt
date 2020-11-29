package com.onurseref.trendyol.data

import com.onurseref.trendyol.ui.widgets.model.WidgetsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface Service {

    @GET("display?widgetPageName=interview")
    fun getWidgets(
        @Header("Content-Type") contentType: String,
        @Header("Build") build: String
    ): Observable<WidgetsResponse>
}
