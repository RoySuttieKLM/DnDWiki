package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails

interface DataSource {

    suspend fun getSpellDetails(index: String): SpellDetails

}
