package com.example.dndwiki.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val getNavigateToSpellFinder = MutableLiveData<Boolean>()
    val navigateToSpellFinder: LiveData<Boolean>
        get() = getNavigateToSpellFinder

    fun onD20Clicked() {
        getNavigateToSpellFinder.value = true
    }

    fun onNavigatedToSpellFinder() {
        getNavigateToSpellFinder.value = false
    }

}