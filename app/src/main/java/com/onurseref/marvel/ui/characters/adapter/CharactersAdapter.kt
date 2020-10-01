package com.onurseref.marvel.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.marvel.R
import com.onurseref.marvel.databinding.ItemCharactersBinding
import com.onurseref.marvel.ui.characters.model.Character
import com.squareup.picasso.Picasso


class CharactersAdapter(private var characterList: List<Character>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemCharactersBinding: ItemCharactersBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        itemCharactersBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_characters,
            parent,
            false
        )
        return NewsViewHolder(itemCharactersBinding)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsViewHolder).bindData(characterList[position])
    }

    class NewsViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(character: Character) {
            binding.character = character
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("setCharacterList")
        fun setCharacterList(recyclerView: RecyclerView, list: List<Character>?) {
            if (list != null) {
                val adapter = CharactersAdapter(list)
                recyclerView.adapter = adapter
            }
        }
    }
}
