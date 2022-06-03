package com.example.dndwiki.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {

    private const val baseUrl = "https://www.dnd5eapi.co/api/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getSpellsApi(): SpellsAPI {
        return getInstance().create(SpellsAPI::class.java)
    }

}