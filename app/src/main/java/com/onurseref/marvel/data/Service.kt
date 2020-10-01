package com.onurseref.marvel.data

import com.onurseref.marvel.ui.characters.model.CharacterResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int?,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Observable<CharacterResponse>
}
