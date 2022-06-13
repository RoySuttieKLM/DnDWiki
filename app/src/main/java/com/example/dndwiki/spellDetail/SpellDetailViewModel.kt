package com.example.dndwiki.spellDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.data.Damage
import com.example.dndwiki.data.DamageType
import com.example.dndwiki.data.School
import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.diModule.DIModule
import com.example.dndwiki.repository.SpellRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SpellDetailViewModel(
    private val repository: SpellRepository = DIModule.provideRepository()
) : ViewModel() {

    data class UiState(
        val isRefreshing: Boolean,
        val spellDetails: SpellDetails,
    )

    private val _uiState = MutableStateFlow(UiState(
        isRefreshing = false,
        spellDetails = SpellDetails()))

    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun onFragmentReady(index: String) {

        _uiState.update { it.copy(isRefreshing = true) }

        viewModelScope.launch {
            val spellDetails = repository.getSpellDetails(index)

            _uiState.update {
                it.copy(
                    isRefreshing = false,
                    spellDetails = spellDetails)
            }
        }
    }
}

