package com.example.dndwiki.diModule

import com.example.dndwiki.home.HomeViewModel
import com.example.dndwiki.spellDetail.SpellDetailViewModel
import com.example.dndwiki.spellFinder.SpellFinderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    viewModel { HomeViewModel() }
    viewModel { SpellFinderViewModel(get()) }
    viewModel { SpellDetailViewModel(get()) }
}