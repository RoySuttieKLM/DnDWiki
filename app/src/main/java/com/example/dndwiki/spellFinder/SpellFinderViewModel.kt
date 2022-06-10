package com.example.dndwiki.spellFinder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.Repository.SpellRepository
import com.example.dndwiki.data.Spells
import com.example.dndwiki.data.SpellsEnvelope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class SpellFinderViewModel : ViewModel() {

    private var repository = SpellRepository()

    data class UiState(
        val isRefreshing: Boolean,
        val spells: List<Spells>,
    )

    private val _uiState = MutableStateFlow(UiState(
        isRefreshing = false,
        spells = emptyList()
    ))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private var temporaryList: List<Spells> = emptyList()

    fun onDataLoading() {
        viewModelScope.launch {

            _uiState.update { it.copy(isRefreshing = true) }

            val envelope: SpellsEnvelope = repository.fetchSpells()
            val spells = envelope.spells
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
            _uiState.update{
                it.copy(spells = temporaryList.filter { mySpell ->
                    mySpell.name.contains(query, ignoreCase = true)})
            }
        } else {
            _uiState.update {
                it.copy(spells = temporaryList)
            }
        }
    }
}