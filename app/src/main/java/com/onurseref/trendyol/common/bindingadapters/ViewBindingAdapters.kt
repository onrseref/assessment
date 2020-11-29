package com.onurseref.trendyol.common.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.onurseref.trendyol.common.extension.setOnDebouncedClickListener


object ViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("invisibleIf")
    fun changeInVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter("onSafeClick")
    fun onSafeClick(view: View, listener: View.OnClickListener) {
        view.setOnDebouncedClickListener {
            listener.onClick(view)
        }
    }
}
