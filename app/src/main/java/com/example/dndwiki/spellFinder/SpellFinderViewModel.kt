package com.example.dndwiki.spellFinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dndwiki.data.Spell
import com.example.dndwiki.network.FakeNetwork


class SpellFinderViewModel : ViewModel() {

    private val _spellsList = MutableLiveData<List<Spell>>()
    val spellsList: LiveData<List<Spell>>
        get() = _spellsList

    fun getSpells() {
        val fakeNetwork = FakeNetwork()
        val spells = fakeNetwork.getSpells()

        _spellsList.value = spells
    }

}



