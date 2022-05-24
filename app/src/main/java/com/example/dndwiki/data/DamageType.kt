package com.example.dndwiki.data

val damageType = listOf(
    DamageType("Acid"), DamageType("Force"), DamageType("Necrotic")
)

data class DamageType(
    val name: String
)