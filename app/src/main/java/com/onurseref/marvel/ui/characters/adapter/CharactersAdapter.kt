package com.onurseref.marvel.ui.characters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onurseref.marvel.R
import com.onurseref.marvel.common.extension.isNotNull
import com.onurseref.marvel.common.extension.setSafeOnClickListener
import com.onurseref.marvel.common.utils.Utils
import com.onurseref.marvel.databinding.ItemCharactersBinding
import com.onurseref.marvel.ui.characters.model.Character


class CharactersAdapter(
    private var characterList: MutableList<Character>,
    private var characterSelectListener: OnCharacterSelectListener,
    private var isLastPage: Boolean
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemCharactersBinding: ItemCharactersBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                itemCharactersBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_characters,
                    parent,
                    false
                )
                CharactersViewHolder(itemCharactersBinding)
            }
            VIEW_TYPE_LOADING -> ProgressHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_loading, parent, false)
            )
            else -> {
                itemCharactersBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_characters,
                    parent,
                    false
                )
                CharactersViewHolder(itemCharactersBinding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == characterList.size) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
    }

    override fun getItemCount(): Int {
        return if (isLastPage) characterList.size else characterList.size + 1
    }

    fun addItems(postItems: ArrayList<Character>, lastPage: Boolean) {
        isLastPage = lastPage
        characterList.addAll(postItems)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CharactersViewHolder) {
            holder.bindData(characterList[position], characterSelectListener)
        } else if (holder is ProgressHolder) {
            holder.bind()
        }
    }

    class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(character: Character, characterSelectListener: OnCharacterSelectListener) {
            binding.character = character
            binding.rootRL.setSafeOnClickListener {
                characterSelectListener.onCharacterSelected(character)
            }
        }
    }

    inner class ProgressHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind() {}
    }

    companion object {

        private const val VIEW_TYPE_LOADING = 0

        private const val VIEW_TYPE_NORMAL = 1

        @JvmStatic
        @BindingAdapter("setCharacterList", "setCharacterSelectListener", "setIsLastPage")
        fun setCharacterList(
            recyclerView: RecyclerView,
            list: ArrayList<Character>?,
            characterSelectListener: OnCharacterSelectListener,
            isLastPage: Boolean
        ) {
            if (list == null) {
                recyclerView.adapter = null
            } else {
                if (recyclerView.adapter == null) {
                    val adapter =
                        CharactersAdapter(
                            list as MutableList<Character>,
                            characterSelectListener,
                            isLastPage
                        )
                    recyclerView.adapter = adapter
                } else {
                    (recyclerView.adapter as CharactersAdapter).addItems(list, isLastPage)
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["setCharacterListRequestListener"])
        fun setCharacterListRequestListener(
            recyclerView: RecyclerView,
            characterListRequestListener: CharacterListRequestListener?
        ) {
            recyclerView.addOnScrollListener(object :
                Utils.PaginationListener(recyclerView.layoutManager as LinearLayoutManager) {
                override fun loadMoreItems() {
                    if (characterListRequestListener.isNotNull()) {
                        characterListRequestListener!!.sendRequest()
                    }
                }
            })
        }
    }

    interface CharacterListRequestListener {
        fun sendRequest()
    }

    interface OnCharacterSelectListener {
        fun onCharacterSelected(character: Character)
    }
}
