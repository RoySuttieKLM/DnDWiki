package com.example.dndwiki.spellFinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.data.Spells
import com.example.dndwiki.data.SpellsEnvelope
import com.example.dndwiki.network.RetroFitHelper
import com.example.dndwiki.network.SpellsAPI
import kotlinx.coroutines.launch


class SpellFinderViewModel : ViewModel() {

    private val _spellsList = MutableLiveData<List<Spells>>()
    val spellsList: LiveData<List<Spells>>
        get() = _spellsList

    fun onViewReady() {


        val apiSpells: SpellsAPI = RetroFitHelper.getSpellsApi()

        viewModelScope.launch {
            val envelope: SpellsEnvelope = apiSpells.getSpells()
            val spells = envelope.spells
            _spellsList.value = spells
        }
    }

    fun onDataLoading() {

        val apiSpells: SpellsAPI = RetroFitHelper.getSpellsApi()

        viewModelScope.launch {
            val envelope: SpellsEnvelope = apiSpells.getSpells()
            val spells = envelope.spells
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
            _spellsList.value = temporaryList
        }
    }

}



