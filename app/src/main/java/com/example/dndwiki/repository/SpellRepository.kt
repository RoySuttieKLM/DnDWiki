package com.example.dndwiki.repository

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.network.ApiSource

class SpellRepository(
    private val api: ApiSource,
    private val db: DBSource,
    private val pref: Preferences
) : DataSource {

    private var repoStatus = true
    //    var isSaving = false

    suspend fun getAllSpellDetails(): List<SpellDetails> {
        if (!isAlreadySavedToday()) {
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

    private fun isAlreadySavedToday(): Boolean {

        //get current date-time
        val currentTime = System.currentTimeMillis()

        //SharedPreferences -> Preferences.kt
        //get last refresh/compare
        pref.getData().apply {

            if (this == 0L) {
                pref.saveData(currentTime)
                return false
            } else if (this > 0L) {

                //if last refresh > 24h -> update with api
                if ((this - currentTime) > 86400000) {
                    //save this update in SharedPreference
                    pref.clearData()
                    pref.saveData(currentTime)
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