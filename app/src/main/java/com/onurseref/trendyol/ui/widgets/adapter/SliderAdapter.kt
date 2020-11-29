package com.onurseref.trendyol.ui.widgets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.trendyol.R
import com.onurseref.trendyol.common.components.CustomSnapHelper
import com.onurseref.trendyol.common.components.LinearLayoutPagerManager
import com.onurseref.trendyol.common.extension.isNotNull
import com.onurseref.trendyol.common.extension.setSafeOnClickListener
import com.onurseref.trendyol.common.utils.Companion.Companion.DISPLAY_TYPE_SLIDER
import com.onurseref.trendyol.common.utils.Companion.Companion.TYPE_BANNER
import com.onurseref.trendyol.common.utils.Companion.Companion.TYPE_PRODUCT
import com.onurseref.trendyol.databinding.ItemSliderBannerContentBinding
import com.onurseref.trendyol.databinding.ItemSliderProductBinding
import com.onurseref.trendyol.ui.widgets.model.BannerContent
import com.onurseref.trendyol.ui.widgets.model.Product
import com.onurseref.trendyol.ui.widgets.model.Widget


/**
 * Created by Onur Şeref on 29.11.2020.
 * Loodos
 * onur.seref@loodos.com
 */
class SliderAdapter(
    private var widget: Widget,
    private var onBannerSelectListener: OnBannerSelectListener,
    private var onProductSelectListener: OnProductSelectListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemSliderBannerContentBinding: ItemSliderBannerContentBinding
    private lateinit var itemSliderProductBinding: ItemSliderProductBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_BANNER -> {
                itemSliderBannerContentBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_slider_banner_content,
                    parent,
                    false
                )
                BannerContentViewHolder(itemSliderBannerContentBinding)
            }
            VIEW_TYPE_PRODUCT -> {
                itemSliderProductBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_slider_product,
                    parent,
                    false
                )
                ProductViewHolder(itemSliderProductBinding)
            }
            else -> {
                itemSliderProductBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_slider_product,
                    parent,
                    false
                )
                ProductViewHolder(itemSliderProductBinding)
            }
        }
    }

    override fun getItemCount(): Int {
        return when (widget.type) {
            TYPE_BANNER -> {
                if (widget.bannerContents?.size?.isNotNull() == true) widget.bannerContents!!.size else 0
            }
            TYPE_PRODUCT -> {
                if (widget.products?.size?.isNotNull() == true) widget.products!!.size else 0
            }
            else -> {
                0
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (widget.type) {
            TYPE_BANNER -> {
                VIEW_TYPE_BANNER
            }
            TYPE_PRODUCT -> {
                VIEW_TYPE_PRODUCT
            }
            else -> 0
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BannerContentViewHolder) {
            holder.bindData(widget.bannerContents?.get(position), onBannerSelectListener)
        } else if (holder is ProductViewHolder) {
            holder.bindData(widget.products?.get(position), onProductSelectListener)
        }
    }

    class BannerContentViewHolder(private val binding: ItemSliderBannerContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(
            bannerContent: BannerContent?,
            onBannerSelectListener: OnBannerSelectListener
        ) {
            binding.bannerContent = bannerContent
            binding.clRoot.setSafeOnClickListener {
                onBannerSelectListener.onBannerSelected(bannerContent)
            }
        }
    }

    class ProductViewHolder(private val binding: ItemSliderProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(product: Product?, onProductSelectListener: OnProductSelectListener) {
            /*val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            params.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())
            binding.clRoot.layoutParams = params

*/
            binding.product = product
            binding.clRoot.setSafeOnClickListener {
                onProductSelectListener.onProductSelected(product)
            }
        }
    }

    companion object {

        private const val VIEW_TYPE_BANNER = 0
        private const val VIEW_TYPE_PRODUCT = 1

        @JvmStatic
        @BindingAdapter(
            "setSlider",
            "setBannerContentsSelectListener",
            "setProductsSelectListener"
        )
        fun setSlider(
            recyclerView: RecyclerView,
            widget: Widget,
            onBannerSelectListener: OnBannerSelectListener,
            onProductSelectListener: OnProductSelectListener
        ) {
            if (widget.isNotNull()) {
                val snapHelper = CustomSnapHelper()
                val adapter =
                    SliderAdapter(
                        widget,
                        onBannerSelectListener,
                        onProductSelectListener
                    )
                if (widget.displayType == DISPLAY_TYPE_SLIDER) {
                    recyclerView.layoutManager = LinearLayoutPagerManager(
                        recyclerView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false,
                        widget.displayCount + 0.5f
                    )
                } else {
                    recyclerView.layoutManager = LinearLayoutManager(
                        recyclerView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                }

                recyclerView.adapter = adapter
                recyclerView.onFlingListener = null
                snapHelper.attachToRecyclerView(recyclerView)
            }
        }
    }

    interface OnBannerSelectListener {
        fun onBannerSelected(bannerContent: BannerContent?)
    }

    interface OnProductSelectListener {
        fun onProductSelected(product: Product?)
    }
}