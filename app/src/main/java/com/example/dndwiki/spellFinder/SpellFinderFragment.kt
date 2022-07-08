package com.example.dndwiki.spellFinder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.databinding.SpellFinderFragmentBinding
import com.example.dndwiki.recycler_adapter.RecyclerAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellFinderFragment : Fragment() {

    private val myAdapter = RecyclerAdapter {
        navigateToSpellDetails(it)
    }

    private lateinit var binding: SpellFinderFragmentBinding

    val viewModel: SpellFinderViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = SpellFinderFragmentBinding.inflate(inflater)

        return binding.root
    }

    private fun navigateToSpellDetails(spell: SpellDetails) {
        val navController = binding.root.findNavController()
        val action =
            SpellFinderFragmentDirections.actionSpellFinderFragmentToSpellDetailFragment(spell.index)
        navController.navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeRefreshLayout = binding.spellFinderSwipeLayout
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.onDataLoading()
        }

        binding.spellFinderRecyclerView.apply {
            swipeRefreshLayout.isRefreshing = true
            layoutManager = LinearLayoutManager(activity)
            adapter = myAdapter
            viewModel.onDataLoading()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collectLatest { state ->
                myAdapter.setData(state.spells)

                swipeRefreshLayout.isRefreshing = state.isRefreshing
            }
        }

        binding.spellFinderSearchBar.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
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