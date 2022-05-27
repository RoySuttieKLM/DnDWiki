package com.example.dndwiki.data

val damageType = listOf(
    DamageType("Acid"), DamageType("Force"), DamageType("Necrotic"), DamageType("Poison")
)

data class DamageType(
    val name: String
)