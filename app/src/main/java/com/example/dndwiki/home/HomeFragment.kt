package com.example.dndwiki.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.dndwiki.R

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = com.example.dndwiki.databinding.HomeFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.navigateToSpellFinder.observe(viewLifecycleOwner
        ) { shouldNavigate ->
            if (shouldNavigate == true) {
                val navController = binding.root.findNavController()
                navController.navigate(R.id.action_homeFragment_to_spellFinderFragment)
                viewModel.onNavigatedToSpellFinder()
            }
        }

        binding.d20Button.setOnClickListener {
            viewModel.onD20Clicked()
        }

        binding.homeFragmentCardView.setOnClickListener {
            viewModel.onD20Clicked()
        }

        return binding.root
    }

}