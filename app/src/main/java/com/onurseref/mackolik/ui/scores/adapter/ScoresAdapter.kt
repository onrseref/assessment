package com.onurseref.mackolik.ui.scores.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.mackolik.R
import com.onurseref.mackolik.common.models.Group
import com.onurseref.mackolik.databinding.ItemScoresBinding


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
}
