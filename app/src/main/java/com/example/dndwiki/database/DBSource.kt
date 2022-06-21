package com.example.dndwiki.database

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.Spells
import com.example.dndwiki.database.spellDetails.SpellDetailsDB
import com.example.dndwiki.database.spellDetails.SpellDetailsDao
import com.example.dndwiki.database.spells.SpellsDB
import com.example.dndwiki.database.spells.SpellsDao
import com.example.dndwiki.repository.DataSource


class DBSource(
    private val spellsDao: SpellsDao,
    private val spellDetailsDao: SpellDetailsDao,
) : DataSource {

    override suspend fun getSpells(): List<Spells> {
        val spells = spellsDao.getAll().map {
            Spells(it.index, it.name)
        }
        return spells
    }

    override suspend fun getSpellDetails(index: String): SpellDetails {
        val spellDetails = spellDetailsDao.findByIndex(index).let {
            SpellDetails(
                it.index,
                it.name,
                it.level,
                it.duration,
                it.desc,
                it.url,
                it.casting_time,
                it.damage!!,
                it.school,
                it.classes,
            )
        }
        return spellDetails
    }

    suspend fun saveSpells(spells: List<Spells>) {
        val dbSpells = spells.map {
            SpellsDB(it.index, it.name)
        }
        spellsDao.insert(dbSpells)
    }

    suspend fun saveSpellDetails(spellDetails: SpellDetails) {
        val dbSpellDetails = spellDetails.let {
            SpellDetailsDB(
                it.index,
                it.name,
                it.level,
                it.duration,
                it.casting_time,
                it.damage,
                it.school,
                it.classes,
                it.url,
                it.desc,
            )
        }

        spellDetailsDao.insert(dbSpellDetails)
    }
}
