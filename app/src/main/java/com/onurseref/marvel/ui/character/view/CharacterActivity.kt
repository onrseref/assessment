package com.onurseref.marvel.ui.character.view

import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.ui.BaseActivity
import com.onurseref.marvel.databinding.ActivityCharacterBinding

class CharacterActivity : BaseActivity() {

    private lateinit var characterBinding: ActivityCharacterBinding

    override fun bindScreen() {
        characterBinding = DataBindingUtil.setContentView(this, R.layout.activity_character)
        characterBinding.lifecycleOwner = this
    }
}
