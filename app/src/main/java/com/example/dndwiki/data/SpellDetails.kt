package com.example.dndwiki.data

data class SpellDetails(
    val index: String,
    val name: String,
    val level: Int,
    val duration: String,
    val desc: List<String>,
    val url: String,
    val casting_time: String,
    val damage: Damage? = null,
    val school: School,
    val classes: List<Classes>,
) {
    constructor() : this(
        " ",
        " ",
        0,
        " ",
        emptyList(),
        " ",
        " ",
        Damage(DamageType()),
        School(" "),
        emptyList(),
    )
}

data class Damage(
    val damage_type: DamageType,
)

data class DamageType(
    val name: String? = null,
)

data class School(
    val name: String,
)

data class Classes(
    val name: String,
)
