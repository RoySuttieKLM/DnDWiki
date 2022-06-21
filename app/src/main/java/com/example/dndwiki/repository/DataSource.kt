package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.Spells

interface DataSource {

    suspend fun getSpells(): List<Spells>

    suspend fun getSpellDetails(index: String): SpellDetails

}
