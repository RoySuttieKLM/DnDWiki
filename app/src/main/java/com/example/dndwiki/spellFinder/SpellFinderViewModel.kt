package com.example.dndwiki.spellFinder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.repository.SpellRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class SpellFinderViewModel(
    private val repository: SpellRepository,
) : ViewModel() {

    data class UiState(
        val isRefreshing: Boolean,
        val spells: List<SpellDetails>,
    )

    private val _uiState = MutableStateFlow(UiState(
        isRefreshing = false,
        spells = emptyList()
    ))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private var temporaryList: List<SpellDetails> = emptyList()

    fun onDataLoading() {

        repository.isOffline(true)

        viewModelScope.launch {

            _uiState.update { it.copy(isRefreshing = true) }


            val spells = repository.getAllSpellDetails()

            temporaryList = spells
            _uiState.update {
                it.copy(
                    isRefreshing = false,
                    spells = spells
                )
            }
        }
    }

    fun onSearchQueryInput(query: String?) {

        if (!query.isNullOrEmpty()) {
            _uiState.update {
                it.copy(spells = temporaryList.filter { mySpell ->
                    mySpell.name.contains(query, ignoreCase = true)
                })
            }
        } else {
            _uiState.update {
                it.copy(spells = temporaryList)
            }
        }
    }
}