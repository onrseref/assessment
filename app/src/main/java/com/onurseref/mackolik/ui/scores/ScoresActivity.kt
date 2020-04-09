package com.onurseref.mackolik.ui.scores

import androidx.databinding.DataBindingUtil
import com.onurseref.mackolik.R
import com.onurseref.mackolik.base.ui.BaseActivity
import com.onurseref.mackolik.databinding.ActivityScoresBinding
import com.onurseref.mackolik.ui.scores.viewmodel.ScoresViewModel
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
