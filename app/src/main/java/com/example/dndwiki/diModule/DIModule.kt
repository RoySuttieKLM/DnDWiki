package com.example.dndwiki.diModule

import com.example.dndwiki.network.ApiSource
import com.example.dndwiki.repository.DataSource
import com.example.dndwiki.repository.SpellRepository
import org.koin.dsl.module

val DnDModule = module {
    single<DataSource> { ApiSource() }
    single { SpellRepository(get()) }
}