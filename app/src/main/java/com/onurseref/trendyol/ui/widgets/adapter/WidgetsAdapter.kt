package com.onurseref.trendyol.ui.widgets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.trendyol.R
import com.onurseref.trendyol.common.extension.isNotNull
import com.onurseref.trendyol.common.utils.Companion.Companion.DISPLAY_TYPE_CAROUSEL
import com.onurseref.trendyol.common.utils.Companion.Companion.DISPLAY_TYPE_LISTING
import com.onurseref.trendyol.common.utils.Companion.Companion.DISPLAY_TYPE_SINGLE
import com.onurseref.trendyol.common.utils.Companion.Companion.DISPLAY_TYPE_SLIDER
import com.onurseref.trendyol.databinding.ItemSingleBannerBinding
import com.onurseref.trendyol.databinding.ItemSliderBinding
import com.onurseref.trendyol.ui.widgets.model.BannerContent
import com.onurseref.trendyol.ui.widgets.model.Widget

class WidgetsAdapter(
    private var widgetList: MutableList<Widget>,
    private var productsSelectListener: SliderAdapter.OnProductSelectListener,
    private var bannerSelectListener: SliderAdapter.OnBannerSelectListener,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemSliderBinding: ItemSliderBinding
    private lateinit var itemSingleBannerBinding: ItemSingleBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_SINGLE -> {
                itemSingleBannerBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_single_banner,
                    parent,
                    false
                )
                SingleBannerViewHolder(itemSingleBannerBinding)
            }
            VIEW_TYPE_SLIDER -> {
                itemSliderBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_slider,
                    parent,
                    false
                )
                WidgetsViewHolder(itemSliderBinding)
            }
            else -> {
                itemSliderBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_slider,
                    parent,
                    false
                )
                WidgetsViewHolder(itemSliderBinding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (widgetList[position].displayType) {
            DISPLAY_TYPE_SLIDER -> {
                VIEW_TYPE_SLIDER
            }
            DISPLAY_TYPE_SINGLE -> {
                VIEW_TYPE_SINGLE
            }
            DISPLAY_TYPE_LISTING -> {
                VIEW_TYPE_LISTING
            }
            DISPLAY_TYPE_CAROUSEL -> {
                VIEW_TYPE_CAROUSEL
            }
            else -> 0
        }
    }

    override fun getItemCount(): Int {
        return widgetList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WidgetsViewHolder) {
            holder.bindData(widgetList[position], productsSelectListener, bannerSelectListener)
        } else if (holder is SingleBannerViewHolder) {
            holder.bindData(widgetList[position].bannerContents?.get(0))
        }
    }

    class WidgetsViewHolder(private val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(
            widget: Widget,
            productsSelectListener: SliderAdapter.OnProductSelectListener,
            bannerSelectListener: SliderAdapter.OnBannerSelectListener
        ) {
            binding.widget = widget
            binding.productsSelectListener = productsSelectListener
            binding.bannerSelectListener = bannerSelectListener
        }
    }

    inner class SingleBannerViewHolder(private val binding: ItemSingleBannerBinding) :
        RecyclerView.ViewHolder(binding.rlRoot) {
        fun bindData(bannerContent: BannerContent?) {
            binding.bannerContent = bannerContent
        }
    }

    companion object {

        private const val VIEW_TYPE_SLIDER = 0
        private const val VIEW_TYPE_SINGLE = 1
        private const val VIEW_TYPE_LISTING = 2
        private const val VIEW_TYPE_CAROUSEL = 3

        @JvmStatic
        @BindingAdapter(
            "setWidgetsList", "setBannerContentsSelectListener", "setProductsSelectListener"
        )
        fun setWidgetsList(
            recyclerView: RecyclerView,
            list: ArrayList<Widget>?,
            bannerSelectListener: SliderAdapter.OnBannerSelectListener,
            productsSelectListener: SliderAdapter.OnProductSelectListener
        ) {
            if (list.isNotNull()) {
                val adapter =
                    WidgetsAdapter(
                        list as MutableList<Widget>,
                        productsSelectListener,
                        bannerSelectListener
                    )
                recyclerView.adapter = adapter
            }
        }
    }
}
