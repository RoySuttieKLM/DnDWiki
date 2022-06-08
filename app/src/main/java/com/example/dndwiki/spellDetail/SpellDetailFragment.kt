package com.example.dndwiki.spellDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.dndwiki.R
import com.example.dndwiki.databinding.SpellDetailFragmentBinding
import kotlinx.coroutines.flow.collectLatest

class SpellDetailFragment : Fragment() {

    private lateinit var binding: SpellDetailFragmentBinding
    val args: SpellDetailFragmentArgs by navArgs()

    private val viewModel: SpellDetailViewModel by lazy {
        ViewModelProvider(this).get(SpellDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = SpellDetailFragmentBinding.inflate(inflater)

        val swipeRefreshLayout = binding.spellDetailSwipeLayout
        swipeRefreshLayout.isRefreshing = true

        binding.spellDetailScrollView.visibility = View.GONE

        viewModel.onFragmentReady(args.spellIndex)

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

    private fun bindData(){
        val swipeRefreshLayout = binding.spellDetailSwipeLayout
        lifecycleScope.launchWhenStarted {
            viewModel.spellDetails.collectLatest { spellDetails ->
                binding.spellNameTextView.text = spellDetails.name

                binding.levelTextView.text = spellDetails.level.toString()
                binding.durationTextView.text = spellDetails.duration.orEmpty()
                binding.castingTimeTextView.text = spellDetails.casting_time.orEmpty()
                if (spellDetails.damage?.damage_type?.name != null) {
                    binding.damageTypeTextView.text = spellDetails.damage.damage_type.name.orEmpty()
                } else {
                    binding.damageTypeTextView.text = getString(R.string.none)
                }
                binding.schoolTextView.text = spellDetails.school?.name.orEmpty()
                if (spellDetails.classes.isNotEmpty()) {
                    binding.dndClasseTextView.text = spellDetails.classes[0].name.orEmpty()
                }
                if (spellDetails.desc.isNotEmpty()) {
                    binding.descriptionTextView.text = spellDetails.desc[0]
                }
                swipeRefreshLayout.isRefreshing = false
                binding.spellDetailScrollView.visibility = View.VISIBLE
            }
        }
    }
}