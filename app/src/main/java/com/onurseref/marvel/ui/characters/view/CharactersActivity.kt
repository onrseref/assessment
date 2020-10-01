package com.onurseref.marvel.ui.characters.view

import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.BaseActivity
import com.onurseref.marvel.databinding.ActivityCharactersBinding
import com.onurseref.marvel.ui.character.view.CharacterActivity
import com.onurseref.marvel.ui.characters.adapter.CharactersAdapter
import com.onurseref.marvel.ui.characters.model.Character
import com.onurseref.marvel.ui.characters.viewmodel.CharactersViewModel
import javax.inject.Inject

class CharactersActivity : BaseActivity(), CharactersAdapter.OnCharacterSelectListener,
    CharactersAdapter.CharacterListRequestListener {

    @Inject
    lateinit var charactersViewModel: CharactersViewModel

    private lateinit var charactersBinding: ActivityCharactersBinding

    override fun bindScreen() {
        charactersBinding = DataBindingUtil.setContentView(this, R.layout.activity_characters)
        charactersBinding.charactersViewModel = charactersViewModel
        charactersBinding.characterSelectListener = this
        charactersBinding.characterListRequestListener = this
        charactersBinding.lifecycleOwner = this
        charactersViewModel.getCharacters()
    }

    override fun onCharacterSelected(character: Character) {
        val intent = Intent(this@CharactersActivity, CharacterActivity::class.java)
        intent.putExtra("character", character)
        startActivity(intent)
    }

    override fun sendRequest() {
        if (!charactersViewModel.isLastPage) {
            charactersViewModel.getCharacters()
        }
    }
}
