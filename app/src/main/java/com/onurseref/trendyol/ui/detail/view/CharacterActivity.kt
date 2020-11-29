package com.onurseref.trendyol.ui.detail.view

import androidx.databinding.DataBindingUtil
import com.onurseref.trendyol.R
import com.onurseref.trendyol.base.BaseActivity
import com.onurseref.trendyol.databinding.ActivityDetailBinding
import com.onurseref.trendyol.ui.widgets.model.Widget

class CharacterActivity : BaseActivity() {

    private lateinit var mActivityDetailBinding: ActivityDetailBinding
    private lateinit var character: Widget

    override fun bindScreen() {
        mActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        mActivityDetailBinding.lifecycleOwner = this

        character = intent.extras?.get("character") as Widget
        mActivityDetailBinding.character = character
    }
}
