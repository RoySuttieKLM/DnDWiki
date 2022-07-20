package com.example.dndwiki.diModule

import com.example.dndwiki.spellDetail.SpellDetailViewModel
import com.example.dndwiki.spellFinder.SpellFinderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SpellFinderViewModel(get()) }
    viewModel { SpellDetailViewModel(get()) }
}