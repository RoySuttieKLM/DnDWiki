package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.Spells
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.network.ApiSource

class SpellRepository(
    private val api: ApiSource,
    private val db: DBSource,
) : DataSource {

    private var alreadyExecuted: Boolean = false
    private var repoStatus = true

    override suspend fun getSpells(): List<Spells> {
        var spells: List<Spells>
        spells = api.getSpells()
        db.saveSpells(spells)
        if (repoStatus) {
            return spells
        } else {
            spells = db.getSpells()
        }
        return spells
    }

    override suspend fun getSpellDetails(index: String): SpellDetails {
        var spellDetails: SpellDetails
        spellDetails = api.getSpellDetails(index)
        if (repoStatus) {
            return spellDetails
        } else {
            spellDetails = db.getSpellDetails(index)
        }
        return spellDetails
    }

    suspend fun saveAllSpellDetails() {
        if (!alreadyExecuted) {
            api.getSpells().forEach {
                db.saveSpellDetails(api
                    .getSpellDetails(it.index))
            }
            alreadyExecuted = true
        }
    }

    fun isOffline(isOffline: Boolean) {
        if (isOffline) {
            repoStatus = false
        }
    }
}