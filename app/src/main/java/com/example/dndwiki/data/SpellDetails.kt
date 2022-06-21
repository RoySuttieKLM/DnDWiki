package com.example.dndwiki.data

import java.io.Serializable

data class SpellDetails(
    val index: String,
    val name: String,
    val level: Int? = null,
    val duration: String? = null,
    val desc: List<String> = emptyList(),
    val url: String? = null,
    val casting_time: String? = null,
    val damage: Damage? = null,
    val school: School? = null,
    val classes: List<Classes> = emptyList(),
) : Serializable {
    constructor() : this(
        " ",
        " ",
        0,
        " ",
        emptyList(),
        " ",
        " ",
        Damage(DamageType()),
        School(),
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
    val name: String? = null,
)

data class Classes(
    var name: String? = null,
)
