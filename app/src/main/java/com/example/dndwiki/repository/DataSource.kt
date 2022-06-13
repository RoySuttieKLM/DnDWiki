package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.SpellsEnvelope

interface DataSource {

    suspend fun getSpells(): SpellsEnvelope

    suspend fun getSpellDetails(index: String): SpellDetails

}
