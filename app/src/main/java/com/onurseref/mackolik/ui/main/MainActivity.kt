package com.onurseref.mackolik.ui.main

import android.content.Intent
import android.view.View
import androidx.databinding.DataBindingUtil
import com.onurseref.mackolik.R
import com.onurseref.mackolik.base.ui.BaseActivity
import com.onurseref.mackolik.databinding.ActivityMainBinding
import com.onurseref.mackolik.ui.news.NewsActivity


/**
 * Created by Onur Şeref on 8.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */
class MainActivity : BaseActivity() {
    override fun bindScreen() {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@MainActivity
        }
    }

    fun funGetNews(view:View) {
        val intent = Intent(this@MainActivity, NewsActivity::class.java)
        startActivity(intent)
        finish()
    }
}