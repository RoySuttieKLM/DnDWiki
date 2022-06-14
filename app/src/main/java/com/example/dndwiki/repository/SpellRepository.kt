package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.Spells

class SpellRepository(
    private val api: DataSource,
) {

    suspend fun getSpells(): List<Spells> {
        return api.getSpells().spells
    }

    suspend fun getSpellDetails(index: String): SpellDetails {
        return api.getSpellDetails(index)
    }
}