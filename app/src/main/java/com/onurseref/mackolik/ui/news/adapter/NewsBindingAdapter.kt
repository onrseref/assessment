package com.onurseref.mackolik.ui.news.adapter

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.mackolik.common.models.Item
import com.onurseref.mackolik.common.models.NewsResponse

object NewsBindingAdapter {
    @JvmStatic
    @BindingAdapter("setList")
    fun setList(recyclerView: RecyclerView, newsResponse: MutableLiveData<NewsResponse>) {
        newsResponse.value.let {
            val adapter = NewsAdapter()
            adapter.list = it!!.rss?.channel?.item as MutableList<Item>
            recyclerView.adapter = adapter
            recyclerView.isScrollContainer = false
            recyclerView.isNestedScrollingEnabled = false
            recyclerView.layoutManager =
                LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)

        }
    }
}