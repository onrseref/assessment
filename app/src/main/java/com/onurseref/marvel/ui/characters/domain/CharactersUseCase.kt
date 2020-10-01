package com.onurseref.marvel.ui.characters.domain

import com.onurseref.marvel.common.extension.isNotNull
import com.onurseref.marvel.data.Repository
import com.onurseref.marvel.ui.characters.model.CharacterResponse
import com.onurseref.marvel.ui.characters.viewstate.CharactersViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersUseCase @Inject constructor(private val repository: Repository) {

    fun getCharacters(): Observable<CharactersViewState> =
        repository.getCharacters()
            .subscribeOn(Schedulers.io())
            .map { getSuccessViewState(it) }
            .onErrorReturn { getFailViewState(it) }
            .startWith(CharactersViewState.Loading)

    private fun getSuccessViewState(it: CharacterResponse): CharactersViewState {
        return if (it.isNotNull()) {
            CharactersViewState.Success(it)
        } else {
            CharactersViewState.Error("Genel hata")
        }
    }

    private fun getFailViewState(throwable: Throwable): CharactersViewState {
        return CharactersViewState.Error(throwable.localizedMessage!!)
    }
}