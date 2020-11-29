package com.onurseref.trendyol.common.components

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt


/**
 * Created by Onur Şeref on 29.11.2020.
 * Loodos
 * onur.seref@loodos.com
 */
class LinearLayoutPagerManager(
    context: Context,
    orientation: Int,
    reverseLayout: Boolean,
    private val itemsPerPage: Float
) : LinearLayoutManager(context, orientation, reverseLayout) {

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
        return super.checkLayoutParams(lp) && lp!!.width.toFloat() == getItemSize()
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return setProperItemSize(super.generateDefaultLayoutParams())
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams): RecyclerView.LayoutParams {
        return setProperItemSize(super.generateLayoutParams(lp))
    }

    private fun setProperItemSize(lp: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
        val itemSize = getItemSize()
        if (orientation == HORIZONTAL) {
            lp.width = itemSize.toInt()
        } else {
            lp.height = itemSize.toInt()
        }
        return lp
    }

    private fun getItemSize(): Float {
        val pageSize = if (orientation == HORIZONTAL) width else height
        return (pageSize.toFloat() / itemsPerPage)
    }
}