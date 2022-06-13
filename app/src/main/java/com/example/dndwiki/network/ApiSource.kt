package com.example.dndwiki.network

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.SpellsEnvelope
import com.example.dndwiki.repository.DataSource

class ApiSource : DataSource {

    override suspend fun getSpells(): SpellsEnvelope {
        return RetroFitHelper.getSpellsApi().getSpells()
    }

    override suspend fun getSpellDetails(index: String): SpellDetails {
        return RetroFitHelper.getSpellsApi().getSpellDetails(index)
    }
}