package com.example.dndwiki.spellFinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dndwiki.data.Spell
import com.example.dndwiki.network.FakeNetwork


class SpellFinderViewModel : ViewModel() {

    private val fakeNetwork = FakeNetwork()

    private val _spellsList = MutableLiveData<List<Spell>>()
    val spellsList: LiveData<List<Spell>>
        get() = _spellsList

    fun onViewReady() {
        val spells = fakeNetwork.getSpells()

        _spellsList.value = spells
    }

    fun onSearchQueryInput(query: String?) {

        val spellsList: List<Spell> = fakeNetwork.getSpells()

        if (query != null) {
            _spellsList.value = spellsList.filter { mySpell ->
                mySpell.name.contains(query, ignoreCase = true)
            }
        } else {
            _spellsList.value = spellsList
        }

    }

}



