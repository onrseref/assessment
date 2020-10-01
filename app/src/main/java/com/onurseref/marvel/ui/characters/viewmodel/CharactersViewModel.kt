package com.onurseref.marvel.ui.characters.viewmodel

import androidx.lifecycle.MutableLiveData
import com.onurseref.marvel.base.BaseViewModel
import com.onurseref.marvel.ui.characters.domain.CharactersUseCase
import com.onurseref.marvel.ui.characters.model.Character
import com.onurseref.marvel.ui.characters.viewstate.CharactersViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase) :
    BaseViewModel() {

    val characterListLiveData = MutableLiveData<ArrayList<Character>?>()
    val isLoadingLiveData = MutableLiveData<Boolean>()
    private val errorMessageLiveData = MutableLiveData<String>()
    var isLastPage = false
    var characterList = ArrayList<Character>()

    fun getCharacters() {
        charactersUseCase.getCharacters(characterList.size)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is CharactersViewState.Loading -> {
                        isLoadingLiveData.postValue(true)
                    }
                    is CharactersViewState.Success -> {
                        isLoadingLiveData.postValue(false)

                        val items = ArrayList<Character>()
                        if (it.characterResponse?.data?.results?.isNullOrEmpty() == false) {
                            items.addAll(it.characterResponse.data.results)
                            characterListLiveData.value = items
                            characterList.addAll(items)
                            isLastPage = characterList.size == it.characterResponse.data.total
                        }
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