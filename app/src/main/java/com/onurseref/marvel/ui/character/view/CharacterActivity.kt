package com.onurseref.marvel.ui.character.view

import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.ui.BaseActivity
import com.onurseref.marvel.databinding.ActivityCharacterBinding
import com.onurseref.marvel.ui.characters.model.Character

class CharacterActivity : BaseActivity() {

    private lateinit var characterBinding: ActivityCharacterBinding
    private lateinit var character: Character

    override fun bindScreen() {
        characterBinding = DataBindingUtil.setContentView(this, R.layout.activity_character)
        characterBinding.lifecycleOwner = this

        character = intent.extras?.get("character") as Character
        characterBinding.character = character
    }
}
