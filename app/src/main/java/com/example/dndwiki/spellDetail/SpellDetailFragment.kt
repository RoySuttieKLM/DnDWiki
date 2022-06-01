package com.example.dndwiki.spellDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.dndwiki.data.Spell
import com.example.dndwiki.databinding.SpellDetailFragmentBinding

class SpellDetailFragment : Fragment() {

    private lateinit var fetchedItem: Spell

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = SpellDetailFragmentBinding.inflate(inflater)

        val args: SpellDetailFragmentArgs by navArgs()
        fetchedItem = args.spell

        binding.spellNameTextView.text = fetchedItem.name
        binding.levelTextView.text = fetchedItem.level.toString()
        binding.durationTextView.text = fetchedItem.duration
        binding.castingTimeTextView.text = fetchedItem.casting_time
        binding.damageTypeTextView.text = fetchedItem.damagetype
        binding.schoolTextView.text = fetchedItem.school
        binding.dndClasseTextView.text = fetchedItem.dndclasse
        binding.descriptionTextView.text = fetchedItem.description

        return binding.root
    }

}