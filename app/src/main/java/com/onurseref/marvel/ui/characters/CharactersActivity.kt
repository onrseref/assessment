package com.onurseref.marvel.ui.characters

import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.ui.BaseActivity
import com.onurseref.marvel.databinding.ActivityCharactersBinding
import com.onurseref.marvel.ui.characters.viewmodel.CharactersViewModel
import javax.inject.Inject

class CharactersActivity : BaseActivity() {

    @Inject
    lateinit var charactersViewModel: CharactersViewModel

    private lateinit var charactersBinding: ActivityCharactersBinding

    override fun bindScreen() {
        charactersBinding = DataBindingUtil.setContentView(this, R.layout.activity_characters)
        charactersBinding.charactersViewModel = charactersViewModel
        charactersBinding.lifecycleOwner = this
        charactersViewModel.getCharacters()
    }
}
