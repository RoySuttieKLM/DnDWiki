package com.example.dndwiki.Repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.Spells
import com.example.dndwiki.data.SpellsEnvelope
import com.example.dndwiki.network.RetroFitHelper
import com.example.dndwiki.network.SpellsAPI

class SpellRepository: SpellInterface {

    override val apiSpells = RetroFitHelper.getSpellsApi()

    suspend fun fetchSpells(): SpellsEnvelope {
        return apiSpells.getSpells()
    }

    suspend fun fetchSpellDetails(index: String): SpellDetails {
        return apiSpells.getSpellDetails(index)
    }
}