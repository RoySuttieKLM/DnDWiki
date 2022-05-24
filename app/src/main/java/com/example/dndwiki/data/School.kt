package com.example.dndwiki.data

val school = listOf(
    School("Conjuration"),
    School("Evocation"),
    School("Necromancy")
)

data class School(
    val name: String
)