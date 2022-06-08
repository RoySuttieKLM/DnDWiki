package com.example.dndwiki.spellFinder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.data.Spells
import com.example.dndwiki.data.SpellsEnvelope
import com.example.dndwiki.network.RetroFitHelper
import com.example.dndwiki.network.SpellsAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class SpellFinderViewModel : ViewModel() {

    private val _spellsList = MutableStateFlow<List<Spells>>(emptyList())
    val spellsList: StateFlow<List<Spells>> = _spellsList.asStateFlow()

    fun onViewReady() {


        val apiSpells: SpellsAPI = RetroFitHelper.getSpellsApi()

        viewModelScope.launch {
            val evenlope: SpellsEnvelope = apiSpells.getSpells()
            val spells = evenlope.spells
            _spellsList.value = spells
        }

    }

    fun onSearchQueryInput(query: String?) {

        val temporaryList: List<Spells> = _spellsList.value!!

        if (!query.isNullOrEmpty()) {
            _spellsList.value = temporaryList.filter { mySpell ->
                mySpell.name.contains(query, ignoreCase = true)
            }
        } else {
            _spellsList.update { temporaryList }
        }
    }

}



