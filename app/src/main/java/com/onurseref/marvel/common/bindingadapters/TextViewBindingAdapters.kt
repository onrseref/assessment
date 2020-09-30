package com.onurseref.marvel.common.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.onurseref.marvel.common.extension.setSafeOnClickListener

object TextViewBindingAdapters {


    @JvmStatic
    @BindingAdapter("bind:onSafeClick")
    fun onSafeClick(view: TextView, onClick: () -> Unit) {
        view.setSafeOnClickListener {
               onClick()
        }

       /*
        view?.setOnDebouncedClickListener {
            onClick()
        }
        */
    }
}

