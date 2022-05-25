package com.example.dndwiki.spellFinder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dndwiki.R
import com.example.dndwiki.adapter.RecyclerAdapter
import com.example.dndwiki.data.Spell
import com.example.dndwiki.databinding.RecyclerItemBinding
import com.example.dndwiki.databinding.SpellFinderFragmentBinding
import com.example.dndwiki.home.HomeFragment
import com.example.dndwiki.network.FakeNetwork

class SpellFinderFragment: Fragment() {


    private var layoutManager: RecyclerView.LayoutManager? = null
    private val myAdapter = RecyclerAdapter()

    lateinit var binding: SpellFinderFragmentBinding

    private val viewModel: SpellFinderViewModel by lazy {
        ViewModelProvider(this).get(SpellFinderViewModel::class.java)
    }

    companion object {
        fun newInstance() = SpellFinderFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

        viewModel.spellsList.observe(viewLifecycleOwner, Observer { spells ->
            myAdapter.setSpells(spells)
        })
        viewModel.getSpells()

    }

}