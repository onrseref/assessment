package com.onurseref.marvel.ui.news

import androidx.databinding.DataBindingUtil
import com.onurseref.marvel.R
import com.onurseref.marvel.base.ui.BaseActivity
import com.onurseref.marvel.databinding.ActivityNewsBinding
import com.onurseref.marvel.ui.news.viewmodel.NewsViewModel
import javax.inject.Inject

class NewsActivity : BaseActivity() {

    @Inject
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsActivityBinding: ActivityNewsBinding

    override fun bindScreen() {
        newsActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)
        newsActivityBinding.newsViewModel = newsViewModel

        newsActivityBinding.lifecycleOwner = this
        newsViewModel.getNews()
    }
}
