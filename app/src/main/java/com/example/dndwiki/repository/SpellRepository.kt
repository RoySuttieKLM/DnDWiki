package com.example.dndwiki.repository

import android.util.Log
import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.network.ApiSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

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
        val spells = api.getSpells()
        val duration = measureTimeMillis {
            withContext(Dispatchers.IO) {
                spells.forEach {
                    launch {
                        Log.d("suttie", "start ${it.name}")
                        val api = async { api.getSpellDetails(it.index) }
                        db.saveSpellDetails(api.await())
                        Log.d("suttie", "got ${it.name}")
                    }
                }
            }
        }
        Log.d("suttie", "duration: $duration milliseconds")
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
    //
    //    fun notLoadingAnymore() {
    //        isSaving = false
    //    }
}