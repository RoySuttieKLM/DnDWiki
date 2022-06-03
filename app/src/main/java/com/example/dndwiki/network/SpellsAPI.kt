package com.example.dndwiki.network

import com.example.dndwiki.data.SpellDetails
import com.example.dndwiki.data.SpellsEnvelope
import retrofit2.http.GET
import retrofit2.http.Path

interface SpellsAPI {

    @GET("spells")
    suspend fun getSpells(): SpellsEnvelope

    @GET("spells/{index}")
    suspend fun getSpellDetails(@Path("index") index: String): SpellDetails

}