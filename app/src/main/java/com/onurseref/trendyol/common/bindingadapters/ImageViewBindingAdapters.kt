package com.onurseref.trendyol.common.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.onurseref.trendyol.R
import com.onurseref.trendyol.common.extension.*
import kotlin.toString


object ImageViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("setImage")
    fun setImage(view: ImageView, url: String?) {
        url?.let {
            view.loadImage(
                view.context,
                "$url",
                view.resDrawable(R.drawable.ic_noimage)
            )
        }
    }

    @JvmStatic
    @BindingAdapter("setImageAndSetSize", "setWidth", "setHeight")
    fun setImageAndSetSize(view: ImageView, url: String?, width: Int, height: Int) {
        url?.let {
            view.loadImageAndSetSize(
                view.context,
                "$url",
                width,
                height,
                view.resDrawable(R.drawable.ic_noimage)
            )
        }
    }


    @JvmStatic
    @BindingAdapter("setImageCenterInside")
    fun setImageCenterInside(view: ImageView, url: String?) {
        url?.let {
            view.loadImageCenterInside(url, null)
        }
    }


    @JvmStatic
    @BindingAdapter("setImageCenterCrop")
    fun setImageCenterCrop(view: ImageView, url: String?) {
        url?.let {
            if (url.isNull())
                view.loadImageCenterCrop(url, view.resDrawable(R.drawable.ic_noimage))
            else
                view.loadImageCenterCrop(url, null)
        }
    }

    @JvmStatic
    @BindingAdapter("setImageFitCenter")
    fun setImageFitCenter(view: ImageView, url: String?) {
        if (url.isNullOrEmpty())
            view.loadImageFitCenter(url.toString(), view.resDrawable(R.drawable.ic_noimage))
        else
            view.loadImageFitCenter(url, null)
    }
}
