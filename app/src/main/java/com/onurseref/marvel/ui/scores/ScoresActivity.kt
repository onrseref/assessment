package com.onurseref.marvel.ui.scores

import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.ui.BaseActivity
import com.onurseref.marvel.databinding.ActivityScoresBinding
import com.onurseref.marvel.ui.scores.viewmodel.ScoresViewModel
import javax.inject.Inject


/**
 * Created by Onur Şeref on 9.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */

class ScoresActivity : BaseActivity() {

    @Inject
    lateinit var scoresViewModel: ScoresViewModel
    lateinit var scoresActivityBinding: ActivityScoresBinding

    override fun bindScreen() {
        scoresActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_scores)
        scoresActivityBinding.scoresViewModel = scoresViewModel

        scoresActivityBinding.lifecycleOwner = this
        scoresViewModel.getScores()
    }
}
