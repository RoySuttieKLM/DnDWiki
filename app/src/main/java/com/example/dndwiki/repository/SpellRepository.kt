package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.SpellsEnvelope
import com.example.dndwiki.network.RetroFitHelper
import kotlinx.coroutines.flow.callbackFlow

class SpellRepository: DataSource {

    private val spellsAPI = RetroFitHelper.getSpellsApi()

    private var spells = SpellsEnvelope()
    private var spellDetails = SpellDetails()

    override suspend fun getSpells(): SpellsEnvelope {
        spells = spellsAPI.getSpells()
        return spells
    }

    override suspend fun getSpellDetails(index: String): SpellDetails {
        spellDetails = spellsAPI.getSpellDetails(index)
        return spellDetails
    }
}