package com.example.dndwiki.data

import java.io.Serializable

data class Spell(
    val casting_time: String,
    val dndclasse: String,
    val damagetype: String,
    val duration: String,
    val index: String,
    val level: Int,
    val name: String,
    val school: String,
    val url: String,
    val description: String,
):Serializable