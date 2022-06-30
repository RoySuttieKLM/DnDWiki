package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.network.ApiSource

class SpellRepository(
    private val api: ApiSource,
    private val db: DBSource,
    private val preferences: Preferences
) : DataSource {

    private var repoStatus = true
    //    var isSaving = false

    suspend fun getAllSpellDetails(): List<SpellDetails> {
        if (!hasBeenSavedInTheLast24Hours()) {
            //            isSaving = true
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
        api.getSpells().forEach {
            db.saveSpellDetails(api.getSpellDetails(it.index))
        }
    }

    fun isOffline(isOffline: Boolean) {
        if (isOffline) {
            repoStatus = false
        }
    }

    private fun hasBeenSavedInTheLast24Hours(): Boolean {
        val currentTime = System.currentTimeMillis()
        val oneDayInMillis: Long = 86400000

        preferences.getLastSaveDate().apply {
            if (this == 0L) {
                preferences.saveDateTime(currentTime)
                return false
            } else if (this > 0L) {
                if ((this - currentTime) > oneDayInMillis) {
                    preferences.saveDateTime(currentTime)
                    return false
                }
            }
            return true
        }
    }
    //
    //    fun notLoadingAnymore() {
    //        isSaving = false
    //    }
}