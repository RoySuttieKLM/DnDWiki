package com.example.dndwiki.spellFinder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dndwiki.adapter.RecyclerAdapter
import com.example.dndwiki.databinding.SpellFinderFragmentBinding

class SpellFinderFragment : Fragment() {

    private val myAdapter = RecyclerAdapter()

    lateinit var binding: SpellFinderFragmentBinding

    private val viewModel: SpellFinderViewModel by lazy {
        ViewModelProvider(this).get(SpellFinderViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = SpellFinderFragmentBinding.inflate(inflater)

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = myAdapter

        }

        viewModel.spellsList.observe(viewLifecycleOwner) { spells ->
            myAdapter.setList(spells)
        }

        viewModel.onViewReady()



        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.onSearchQueryInput(p0)
                return true
            }

        })

    }

}