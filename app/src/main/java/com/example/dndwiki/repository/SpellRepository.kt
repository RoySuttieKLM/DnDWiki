package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.network.ApiSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpellRepository(
    private val api: ApiSource,
    private val db: DBSource,
    private val preferences: Preferences
) : DataSource {

    private var repoStatus = true

    suspend fun getAllSpellDetails(): List<SpellDetails> {
        if (!hasBeenSavedInTheLast24Hours()) {
            saveAllSpellDetails()
        }
        return db.getAllSpellDetails()
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

    private suspend fun saveAllSpellDetails() {
        val spells = api.getSpells()
        val spellDetails = mutableListOf<SpellDetails>()
        withContext(Dispatchers.IO) {
            spells.forEach {
                launch {
                    spellDetails.add(getSpellDetails(it.index))
                }
            }
            db.saveAllSpellDetails(spellDetails)
        }
    }


    fun isOffline(isOffline: Boolean) {
        if (isOffline) {
            repoStatus = false
        }
    }

    private fun hasBeenSavedInTheLast24Hours(): Boolean {
        val currentTime = System.currentTimeMillis()
        val oneDayInMillis = 86400000L
        val defaultValue = 0L

        preferences.getLastSaveDate().apply {
            if (this == defaultValue) {
                preferences.saveDateTime(currentTime)
                return false
            } else if (this > defaultValue) {
                if ((this - currentTime) > oneDayInMillis) {
                    preferences.saveDateTime(currentTime)
                    return false
                }
            }
            return true
        }
    }
}