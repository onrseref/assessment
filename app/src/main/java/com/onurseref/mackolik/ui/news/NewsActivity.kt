package com.onurseref.mackolik.ui.news

import androidx.databinding.DataBindingUtil
import com.onurseref.mackolik.R
import com.onurseref.mackolik.base.ui.BaseActivity
import com.onurseref.mackolik.databinding.ActivityNewsBinding
import com.onurseref.mackolik.ui.news.viewmodel.NewsViewModel
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
