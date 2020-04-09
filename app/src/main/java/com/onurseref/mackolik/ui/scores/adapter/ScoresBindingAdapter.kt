package com.onurseref.mackolik.ui.scores.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.mackolik.common.models.Group
import com.onurseref.mackolik.common.models.ScoresResponse

object ScoresBindingAdapter {
    @JvmStatic
    @BindingAdapter("setGroupList")
    fun setGroupList(recyclerView: RecyclerView, scoresResponse: ScoresResponse?) {
        scoresResponse?.let {
            val adapter = ScoresAdapter()
            adapter.groupList = it.gsmrs?.competition?.season?.round?.group as MutableList<Group>
            recyclerView.adapter = adapter
            recyclerView.isScrollContainer = false
            recyclerView.isNestedScrollingEnabled = false
            recyclerView.layoutManager =
                LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        }
    }
}