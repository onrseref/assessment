package com.onurseref.trendyol.ui.widgets.view

import androidx.databinding.DataBindingUtil
import com.onurseref.trendyol.R
import com.onurseref.trendyol.base.BaseActivity
import com.onurseref.trendyol.databinding.ActivityWidgetsBinding
import com.onurseref.trendyol.ui.widgets.adapter.SliderAdapter
import com.onurseref.trendyol.ui.widgets.model.BannerContent
import com.onurseref.trendyol.ui.widgets.model.Product
import com.onurseref.trendyol.ui.widgets.viewmodel.WidgetsViewModel
import javax.inject.Inject

class WidgetsActivity : BaseActivity(),
    SliderAdapter.OnProductSelectListener,
    SliderAdapter.OnBannerSelectListener {

    @Inject
    lateinit var mWidgetsViewModel: WidgetsViewModel

    private lateinit var mActivityWidgetsBinding: ActivityWidgetsBinding

    override fun bindScreen() {
        mActivityWidgetsBinding = DataBindingUtil.setContentView(this, R.layout.activity_widgets)
        mActivityWidgetsBinding.widgetsViewModel = mWidgetsViewModel
        mActivityWidgetsBinding.bannerContentsSelectListener = this
        mActivityWidgetsBinding.productsSelectListener = this
        mActivityWidgetsBinding.lifecycleOwner = this
        mWidgetsViewModel.getWidgets()
    }

    override fun onBannerSelected(bannerContent: BannerContent?) {
        val x = 0
    }

    override fun onProductSelected(product: Product?) {
        val x = 0
    }
}
