package com.onurseref.marvel.ui.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.marvel.R
import com.onurseref.marvel.common.models.Item
import com.onurseref.marvel.common.models.NewsResponse
import com.onurseref.marvel.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso


class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<Item> = mutableListOf()

    private lateinit var context: Context
    private lateinit var itemNewsBinding: ItemNewsBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        itemNewsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_news,
            parent,
            false
        )
        return NewsViewHolder(itemNewsBinding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        list.let {
            (holder as NewsViewHolder).bindData(it[position])
        }
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: Item) {
            binding.item = item
            Picasso.get().load(item.enclosure?._url).into(binding.ivNews)
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("setList")
        fun setList(recyclerView: RecyclerView, newsResponse: NewsResponse?) {
            newsResponse?.let {
                val adapter = NewsAdapter()
                adapter.list = it.rss?.channel?.item as ArrayList<Item>
                recyclerView.adapter = adapter
                recyclerView.isScrollContainer = false
                recyclerView.isNestedScrollingEnabled = false
                recyclerView.layoutManager =
                    LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }
}
