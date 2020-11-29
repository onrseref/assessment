package com.onurseref.trendyol.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.trendyol.R
import com.onurseref.trendyol.common.components.CustomSnapHelper
import com.onurseref.trendyol.databinding.ItemImageSliderBinding


class ImageSliderAdapter(private var imageUrls: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemImageSliderBinding: ItemImageSliderBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        itemImageSliderBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_image_slider,
            parent,
            false
        )
        return ImageSliderViewHolder(itemImageSliderBinding)
    }

    override fun getItemCount(): Int = imageUrls.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageSliderViewHolder).bindData(imageUrls[position])
    }

    class ImageSliderViewHolder(private val binding: ItemImageSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(imageUrl: String) {
            binding.imageUrl = imageUrl
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("setImageSliderList")
        fun setImageSliderList(recyclerView: RecyclerView, list: List<String>?) {
            if (list != null) {
                val snapHelper = CustomSnapHelper()
                val adapter = ImageSliderAdapter(list)

                recyclerView.adapter = adapter
                recyclerView.onFlingListener = null
                snapHelper.attachToRecyclerView(recyclerView)
            }
        }
    }
}
