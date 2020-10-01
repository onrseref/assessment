package com.onurseref.marvel.data

import com.onurseref.marvel.ui.characters.model.CharacterResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    fun getCharacters(offset: Int?): Observable<CharacterResponse> = remoteDataSource
        .getCharacters(offset)
        .subscribeOn(Schedulers.io())
}