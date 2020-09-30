package com.onurseref.marvel.data.service

import com.onurseref.marvel.common.models.NewsResponse
import com.onurseref.marvel.common.models.ScoresResponse
import retrofit2.http.GET
import io.reactivex.Observable

interface Service {

    @GET("latestnews")
    fun getNews(): Observable<NewsResponse>


    @GET("scores")
    fun getScores(): Observable<ScoresResponse>

}
