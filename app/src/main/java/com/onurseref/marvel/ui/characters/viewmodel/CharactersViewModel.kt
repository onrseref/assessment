package com.onurseref.marvel.ui.characters.viewmodel

import androidx.lifecycle.MutableLiveData
import com.onurseref.marvel.base.ui.BaseViewModel
import com.onurseref.marvel.ui.characters.domain.CharactersUseCase
import com.onurseref.marvel.ui.characters.model.Character
import com.onurseref.marvel.ui.characters.viewstate.CharactersViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase) :
    BaseViewModel() {

    val characterList = MutableLiveData<List<Character>?>()
    val isLoadingLiveData = MutableLiveData<Boolean>()
    val errorMessageLiveData = MutableLiveData<String>()

    fun getCharacters() {
        charactersUseCase.getCharacters()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is CharactersViewState.Loading -> {
                        isLoadingLiveData.postValue(true)
                    }
                    is CharactersViewState.Success -> {
                        isLoadingLiveData.postValue(false)
                        characterList.postValue(it.characterResponse?.data?.results)
                    }
                    else -> {
                        isLoadingLiveData.postValue(false)
                        errorMessageLiveData.postValue((it as CharactersViewState.Error).throwable)
                    }
                }
            }
            .also { disposable += it }
    }
}