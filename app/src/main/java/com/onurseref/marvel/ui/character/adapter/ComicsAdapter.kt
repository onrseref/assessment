package com.onurseref.marvel.ui.character.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.marvel.R
import com.onurseref.marvel.databinding.ItemComicBinding
import com.onurseref.marvel.ui.characters.model.Items


class ComicsAdapter(private var itemList: List<Items>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemComicBinding: ItemComicBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        itemComicBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_comic,
            parent,
            false
        )
        return ComicViewHolder(itemComicBinding)
    }

    override fun getItemCount(): Int = if (itemList.size > 10) 10 else itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ComicViewHolder).bindData(itemList[position])
    }

    class ComicViewHolder(private val binding: ItemComicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: Items) {
            binding.item = item
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("setComicsList")
        fun setComicsList(recyclerView: RecyclerView, list: List<Items>?) {
            if (list != null) {
                val adapter = ComicsAdapter(list)
                recyclerView.adapter = adapter
            }
        }
    }
}
