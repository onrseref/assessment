package com.onurseref.marvel.ui.main

import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.ui.BaseActivity
import com.onurseref.marvel.databinding.ActivityMainBinding
import com.onurseref.marvel.ui.news.NewsActivity
import com.onurseref.marvel.ui.scores.ScoresActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by Onur Şeref on 8.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */
class MainActivity : BaseActivity(), AdapterView.OnItemSelectedListener {

    var spinnerItems = arrayOf("Choose", "News", "Scores")

    override fun bindScreen() {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@MainActivity
        }


        spinner.onItemSelectedListener = this
        val arrayAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.spinner_item, spinnerItems)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spinner.adapter = arrayAdapter


    }

    override fun onItemSelected(
        arg0: AdapterView<*>?,
        arg1: View?,
        position: Int,
        id: Long
    ) {
        if (position == 1) {
            funGetNews()
        } else if (position == 2) {
            funGetScores()
        }
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    private fun funGetNews() {
        val intent = Intent(this@MainActivity, NewsActivity::class.java)
        startActivity(intent)
    }

    private fun funGetScores() {
        val intent = Intent(this@MainActivity, ScoresActivity::class.java)
        startActivity(intent)
    }
}