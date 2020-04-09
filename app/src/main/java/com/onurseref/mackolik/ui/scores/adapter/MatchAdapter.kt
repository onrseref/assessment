package com.onurseref.mackolik.ui.scores.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.mackolik.R
import com.onurseref.mackolik.common.models.Match
import com.onurseref.mackolik.databinding.ItemMatchBinding


/**
 * Created by Onur Şeref on 9.04.2020.
 * Loodos
 * onur.seref@loodos.com
 */

class MatchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var matchList: MutableList<Match> = mutableListOf()

    private lateinit var context: Context
    private lateinit var itemMatchBinding: ItemMatchBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        itemMatchBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_match,
            parent,
            false
        )
        return MatchViewHolder(itemMatchBinding)
    }

    override fun getItemCount(): Int = matchList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        matchList.let {
            (holder as MatchViewHolder).bindData(it[position])
        }
    }

    class MatchViewHolder(private val binding: ItemMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(match: Match) {
            binding.match = match
        }
    }
}