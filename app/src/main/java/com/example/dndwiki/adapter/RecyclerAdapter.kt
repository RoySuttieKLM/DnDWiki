package com.example.dndwiki.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dndwiki.R
import com.example.dndwiki.data.Spell

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data: List<Spell> = emptyList()

    fun setSpells(list: List<Spell>) {

        data = list

         notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, i: Int) {

        holder.bind(data[i])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val itemSpellName: TextView = itemView.findViewById(R.id.item_spell_name)

        fun bind(spell: Spell) {
            itemSpellName.text = spell.name
        }

    }

}