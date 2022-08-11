package com.example.dndwiki.diceRoller

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.dndwiki.R
import com.example.dndwiki.databinding.DiceRollerFragmentBinding
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiceRollerFragment : Fragment() {

    private val viewModel: DiceRollerViewModel by viewModel()

    private lateinit var binding: DiceRollerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DiceRollerFragmentBinding.inflate(inflater)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.d20CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d20Count.text = viewModel.rollD20()
        }

        binding.d100CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d100Count.text = viewModel.rollD100()
        }

        binding.d10CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d10Count.text = viewModel.rollD10()
        }

        binding.d8CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d8Count.text = viewModel.rollD8()
        }

        binding.d6CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d6Count.text = viewModel.rollD6()
        }

        binding.d12CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d12Count.text = viewModel.rollD12()
        }

        binding.d4CountButton.setOnClickListener {
            playDiceSound()
            Thread.sleep(1000)
            binding.d4Count.text = viewModel.rollD4()
        }
    }

    private fun playDiceSound() {
        val audioId = resources.getIdentifier(
            R.raw.dice_sound_improved.toString(),
            "raw",
            activity?.packageName)
        val mediaPlayer = MediaPlayer.create(activity, audioId)
        mediaPlayer.start()
    }

}