package com.example.dndwiki.recycler_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dndwiki.R
import com.example.dndwiki.data.SpellDetails

class RecyclerAdapter(
    val onClick: (spell: SpellDetails) -> Unit,
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data: List<SpellDetails> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.spell_finder_recycler_item, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.bind(data[i])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemSpellName: TextView = itemView.findViewById(R.id.item_spell_name)

        fun bind(spell: SpellDetails) {
            itemSpellName.text = spell.name

            itemView.setOnClickListener {
                onClick(spell)
            }
        }
    }

    fun setData(list: List<SpellDetails>) {
        val diffUtil = RecyclerViewDiffUtil(data, list)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        data = list
        diffResults.dispatchUpdatesTo(this)
    }
}