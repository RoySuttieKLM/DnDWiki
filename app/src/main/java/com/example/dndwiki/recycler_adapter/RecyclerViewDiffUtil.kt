package com.example.dndwiki.recycler_adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.dndwiki.data.SpellDetails

class RecyclerViewDiffUtil(
    private val oldList: List<SpellDetails>,
    private val newList: List<SpellDetails>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.count()
    }

    override fun getNewListSize(): Int {
        return newList.count()
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].index == newList[newItemPosition].index
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].index != newList[newItemPosition].index -> {
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            else -> true
        }
    }
}