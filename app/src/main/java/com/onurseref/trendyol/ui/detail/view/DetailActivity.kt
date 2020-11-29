package com.onurseref.trendyol.ui.detail.view

import androidx.databinding.DataBindingUtil
import com.onurseref.trendyol.R
import com.onurseref.trendyol.base.BaseActivity
import com.onurseref.trendyol.common.utils.Companion.Companion.TYPE_BANNER
import com.onurseref.trendyol.common.utils.Companion.Companion.TYPE_PRODUCT
import com.onurseref.trendyol.databinding.ActivityDetailBinding
import com.onurseref.trendyol.ui.widgets.model.BannerContent
import com.onurseref.trendyol.ui.widgets.model.Product

class DetailActivity : BaseActivity() {

    private lateinit var mActivityDetailBinding: ActivityDetailBinding
    private var bannerContent: BannerContent? = null
    private var product: Product? = null

    override fun bindScreen() {
        mActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        mActivityDetailBinding.lifecycleOwner = this

        bannerContent = intent.extras?.get(TYPE_BANNER) as BannerContent?
        product = intent.extras?.get(TYPE_PRODUCT) as Product?

        mActivityDetailBinding.bannerContent = bannerContent
        mActivityDetailBinding.product = product
    }
}
