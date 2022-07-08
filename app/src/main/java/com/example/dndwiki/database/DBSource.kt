package com.example.dndwiki.database

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.database.spellDetails.SpellDetailsDB
import com.example.dndwiki.database.spellDetails.SpellDetailsDao
import com.example.dndwiki.database.spellDetails.toSpellDetails
import com.example.dndwiki.database.spellDetails.toSpellDetailsDB
import com.example.dndwiki.repository.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DBSource(
    private val spellDetailsDao: SpellDetailsDao,
) : DataSource {

    suspend fun getAllSpellDetails(): List<SpellDetails> {
        val allSpellDetails = spellDetailsDao.getAll()

        return allSpellDetails.map {
            it.toSpellDetails()
        }
    }

    override suspend fun getSpellDetails(index: String): SpellDetails {
        return spellDetailsDao.findByIndex(index).toSpellDetails()
    }

    suspend fun saveAllSpellDetails(spellDetails: List<SpellDetails>) {
        val spellDetailsDB = spellDetails.map {
            it.toSpellDetailsDB()
        }
        spellDetailsDao.insertAll(spellDetailsDB)
    }
}
