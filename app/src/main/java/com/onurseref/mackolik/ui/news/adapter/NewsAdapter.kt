package com.onurseref.mackolik.ui.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.mackolik.R
import com.onurseref.mackolik.common.models.Item
import com.onurseref.mackolik.databinding.ItemNewsBinding


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

        }
    }
}
