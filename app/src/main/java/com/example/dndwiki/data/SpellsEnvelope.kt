package com.example.dndwiki.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpellsEnvelope(
    @SerializedName("results")
    val spells: List<Spells> = emptyList(),
) {
    constructor() : this(
        emptyList(),
    )
}


data class Spells(
    val index: String,
    val name: String,
) : Serializable
