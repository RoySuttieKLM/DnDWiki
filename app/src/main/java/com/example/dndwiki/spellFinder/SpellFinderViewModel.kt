package com.example.dndwiki.spellFinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dndwiki.data.Spell
import com.example.dndwiki.network.FakeNetwork


class SpellFinderViewModel : ViewModel() {


//    private val getNavigateToSpellDetail = MutableLiveData<Boolean>()
//    val navigateToSpellDetail: LiveData<Boolean>
//        get() = getNavigateToSpellDetail

    private val fakeNetwork = FakeNetwork()

    private val _spellsList = MutableLiveData<List<Spell>>()
    val spellsList: LiveData<List<Spell>>
        get() = _spellsList

    fun onViewReady() {
        val spells = fakeNetwork.spells

        _spellsList.value = spells
    }

    fun onSearchQueryInput(query: String?) {

        val temporaryList: List<Spell> = fakeNetwork.spells

        if (!query.isNullOrEmpty()) {
            _spellsList.value = temporaryList.filter { mySpell ->
                mySpell.name.contains(query, ignoreCase = true)
            }
        } else {
            _spellsList.value = temporaryList
        }
    }

}



