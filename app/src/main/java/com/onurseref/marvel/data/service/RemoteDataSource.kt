package com.onurseref.marvel.data.service

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: Service) {

    fun getNews() = service.getNews()
    fun getScores() = service.getScores()
}