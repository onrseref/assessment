package com.onurseref.mackolik.ui.news

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.onurseref.mackolik.R
import com.onurseref.mackolik.base.ui.BaseActivity
import com.onurseref.mackolik.databinding.ActivityNewsBinding
import com.onurseref.mackolik.ui.news.viewmodel.NewsViewModel

class NewsActivity : BaseActivity() {

    private lateinit var newsViewModel: NewsViewModel

    override fun bindScreen() {
        newsViewModel =
            ViewModelProviders.of(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        DataBindingUtil.setContentView<ActivityNewsBinding>(this, R.layout.activity_news).apply {
            this.lifecycleOwner = this@NewsActivity
            this.newsViewModel = newsViewModel
        }
        newsViewModel.getNews()
    }
}
