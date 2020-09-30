package com.onurseref.marvel.ui.scores.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.marvel.R
import com.onurseref.marvel.common.models.Group
import com.onurseref.marvel.common.models.ScoresResponse
import com.onurseref.marvel.databinding.ItemScoresBinding


class ScoresAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var groupList: MutableList<Group> = mutableListOf()

    private lateinit var context: Context
    private lateinit var itemScoresBinding: ItemScoresBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        itemScoresBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_scores,
            parent,
            false
        )
        return ScoresViewHolder(itemScoresBinding)
    }

    override fun getItemCount(): Int = groupList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        groupList.let {
            (holder as ScoresViewHolder).bindData(it[position])
        }
    }

    class ScoresViewHolder(private val binding: ItemScoresBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(group: Group) {
            binding.group = group

        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("setGroupList")
        fun setGroupList(recyclerView: RecyclerView, scoresResponse: ScoresResponse?) {
            scoresResponse?.let {
                val adapter = ScoresAdapter()
                adapter.groupList =
                    it.gsmrs?.competition?.season?.round?.group as MutableList<Group>
                recyclerView.adapter = adapter
                recyclerView.isScrollContainer = false
                recyclerView.isNestedScrollingEnabled = false
                recyclerView.layoutManager =
                    LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }
}
