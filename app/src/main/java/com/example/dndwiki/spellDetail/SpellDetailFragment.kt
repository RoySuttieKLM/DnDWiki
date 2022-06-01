package com.example.dndwiki.spellDetail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.dndwiki.data.Spell
import com.example.dndwiki.databinding.SpellDetailFragmentBinding

class SpellDetailFragment : Fragment() {

    private lateinit var spell: Spell

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = SpellDetailFragmentBinding.inflate(inflater)

        val args: SpellDetailFragmentArgs by navArgs()
        spell = args.spell

        binding.spellNameTextView.text = spell.name
        binding.levelTextView.text = spell.level.toString()
        binding.durationTextView.text = spell.duration
        binding.castingTimeTextView.text = spell.casting_time
        binding.damageTypeTextView.text = spell.damagetype
        binding.schoolTextView.text = spell.school
        binding.dndClasseTextView.text = spell.dndclasse
        binding.descriptionTextView.text = spell.description

        return binding.root
    }
}