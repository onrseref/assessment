package com.onurseref.marvel.ui.characters.viewstate

import com.onurseref.marvel.ui.characters.model.CharacterResponse

sealed class CharactersViewState {
    object Loading : CharactersViewState()
    data class Error(val throwable: String) :
        CharactersViewState()

    data class Success(val characterResponse: CharacterResponse?) :
        CharactersViewState()
}
