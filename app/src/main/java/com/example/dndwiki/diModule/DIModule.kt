package com.example.dndwiki.diModule

import com.example.dndwiki.network.ApiSource
import com.example.dndwiki.repository.DataSource
import com.example.dndwiki.repository.SpellRepository

object DIModule {

    fun provideRepository() : SpellRepository {
        return SpellRepository()
    }

    fun provideDataSource() : DataSource {
        return ApiSource()
    }

}
