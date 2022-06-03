package com.example.dndwiki.spellDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.network.RetroFitHelper
import com.example.dndwiki.network.SpellsAPI
import kotlinx.coroutines.launch

class SpellDetailViewModel : ViewModel() {

    private val _spellDetails = MutableLiveData<SpellDetails>()
    val spellDetails: LiveData<SpellDetails>
        get() = _spellDetails

    fun onFragmentReady(index: String) {

        val apiSpells: SpellsAPI = RetroFitHelper.getSpellsApi()

        viewModelScope.launch {
            val spellDetails: SpellDetails = apiSpells.getSpellDetails(index)
            _spellDetails.value = spellDetails
        }

    }

}