package com.onurseref.trendyol.common.components

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Onur Şeref on 29.11.2020.
 * Loodos
 * onur.seref@loodos.com
 */
class CustomSnapHelper : LinearSnapHelper() {
    override fun findSnapView(layoutManager: RecyclerView.LayoutManager?): View? {
        if (layoutManager is LinearLayoutManager) {
            if (!shouldSnap(layoutManager)) {
                return null
            }
        }
        return super.findSnapView(layoutManager)
    }

    private fun shouldSnap(linearLayoutManager: LinearLayoutManager): Boolean {
        return linearLayoutManager.findFirstCompletelyVisibleItemPosition() != 0
                && linearLayoutManager.findLastCompletelyVisibleItemPosition() != linearLayoutManager.itemCount - 1
    }
}