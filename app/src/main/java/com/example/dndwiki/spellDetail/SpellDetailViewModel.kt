package com.example.dndwiki.spellDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.Repository.SpellRepository
import com.example.dndwiki.data.Damage
import com.example.dndwiki.data.DamageType
import com.example.dndwiki.data.School
import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.network.RetroFitHelper
import com.example.dndwiki.network.SpellsAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SpellDetailViewModel : ViewModel() {

    private var repository = SpellRepository()

    private val initSpellDetails = SpellDetails(" ",
        " ",
        0,
        " ",
        emptyList(),
        " ",
        " ",
        Damage(DamageType()),
        School(),
        emptyList()
    )

    private val _spellDetails = MutableStateFlow(initSpellDetails)
    val spellDetails: StateFlow<SpellDetails> = _spellDetails.asStateFlow()

    fun onFragmentReady(index: String) {

        viewModelScope.launch {
            val spellDetails = repository.fetchSpellDetails(index)

            _spellDetails.update { spellDetails }
        }
    }
}

