package com.example.dndwiki.network

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.Spells
import com.example.dndwiki.repository.DataSource

class ApiSource : DataSource {

    suspend fun getSpells(): List<Spells> {
        return RetroFitHelper.getSpellsApi().getSpells().spells
    }

    override suspend fun getSpellDetails(index: String): SpellDetails {
        return RetroFitHelper.getSpellsApi().getSpellDetails(index)
    }

}