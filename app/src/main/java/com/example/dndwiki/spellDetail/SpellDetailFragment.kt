package com.example.dndwiki.spellDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.dndwiki.R
import com.example.dndwiki.databinding.SpellDetailFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellDetailFragment : Fragment() {

    private lateinit var binding: SpellDetailFragmentBinding
    private val args: SpellDetailFragmentArgs by navArgs()

    private val viewModel: SpellDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = SpellDetailFragmentBinding.inflate(inflater)

        val swipeRefreshLayout = binding.spellDetailSwipeLayout

        binding.spellDetailScrollView.visibility = View.GONE

        viewModel.onFragmentReady(args.spellIndex)

        swipeRefreshLayout.isRefreshing = true

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeRefreshLayout = binding.spellDetailSwipeLayout
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.onFragmentReady(args.spellIndex)
        }

        bindData()
    }

    private fun bindData() {
        val swipeRefreshLayout = binding.spellDetailSwipeLayout

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collectLatest { spellDetails ->
                binding.spellNameTextView.text = spellDetails.spellDetails.name
                binding.levelTextView.text = spellDetails.spellDetails.level.toString()
                binding.durationTextView.text = spellDetails.spellDetails.duration.orEmpty()
                binding.castingTimeTextView.text = spellDetails.spellDetails.casting_time.orEmpty()
                if (spellDetails.spellDetails.damage?.damage_type?.name != null) {
                    binding.damageTypeTextView.text =
                        spellDetails.spellDetails.damage.damage_type.name.orEmpty()
                } else {
                    binding.damageTypeTextView.text = getString(R.string.none)
                }
                binding.schoolTextView.text = spellDetails.spellDetails.school?.name.orEmpty()
                if (spellDetails.spellDetails.classes.isNotEmpty()) {
                    binding.dndClasseTextView.text =
                        spellDetails.spellDetails.classes[0].name.orEmpty()
                }
                if (spellDetails.spellDetails.desc.isNotEmpty()) {
                    binding.descriptionTextView.text = spellDetails.spellDetails.desc[0]
                }
                swipeRefreshLayout.isRefreshing = false
                binding.spellDetailScrollView.visibility = View.VISIBLE
            }
        }
    }
}