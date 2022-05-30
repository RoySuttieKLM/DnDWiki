package com.example.dndwiki.spellDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dndwiki.databinding.SpellDetailFragmentBinding

class SpellDetailFragment : Fragment() {

    private val viewModel: SpellDetailViewModel by lazy {
        ViewModelProvider(this).get(SpellDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = SpellDetailFragmentBinding.inflate(inflater)



        return binding.root
    }

}