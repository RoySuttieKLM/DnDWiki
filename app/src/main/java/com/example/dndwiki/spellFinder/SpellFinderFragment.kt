package com.example.dndwiki.spellFinder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dndwiki.R
import com.example.dndwiki.data.Spell
import com.example.dndwiki.databinding.SpellFinderFragmentBinding
import com.example.dndwiki.recycler_adapter.RecyclerAdapter

class SpellFinderFragment: Fragment() {

    private val myAdapter = RecyclerAdapter {
        navigateToSpellDetails(it)
    }

    private lateinit var binding: SpellFinderFragmentBinding

    private val viewModel: SpellFinderViewModel by lazy {
        ViewModelProvider(this).get(SpellFinderViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = SpellFinderFragmentBinding.inflate(inflater)

        return binding.root
    }

    private fun navigateToSpellDetails(spell: Spell) {
        val navController = binding.root.findNavController()
        val action = SpellFinderFragmentDirections.actionSpellFinderFragmentToSpellDetailFragment(spell)
        navController.navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spellFinderRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = myAdapter

        }

        viewModel.spellsList.observe(viewLifecycleOwner) { spells ->
            myAdapter.setSpells(spells)
        }

        viewModel.onViewReady()

        binding.spellFinderSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                viewModel.onSearchQueryInput(query)
                return true
            }
        })
    }
}