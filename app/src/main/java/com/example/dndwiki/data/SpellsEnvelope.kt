package com.example.dndwiki.data

import com.google.gson.annotations.SerializedName

data class SpellsEnvelope(
    @SerializedName("results")
    val spells: List<Spells> = emptyList(),
)

data class Spells(
    val index: String,
    val name: String,
) {
    constructor() : this(
        " ",
        " ",
    )
}
