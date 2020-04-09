package com.onurseref.mackolik.ui.scores.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.mackolik.common.models.Group
import com.onurseref.mackolik.common.models.Match


/**
 * Created by Onur Şeref on 9.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */

object MatchBindingAdapter {
    @JvmStatic
    @BindingAdapter("setMatchList")
    fun setMatchList(recyclerView: RecyclerView, group: Group?) {
        group?.let {
            val adapter = MatchAdapter()
            adapter.matchList = group.match as MutableList<Match>
            recyclerView.adapter = adapter
            recyclerView.isScrollContainer = false
            recyclerView.isNestedScrollingEnabled = false
            recyclerView.layoutManager =
                LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        }
    }
}