package com.example.dndwiki.database.spellDetails

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dndwiki.data.Classes
import com.example.dndwiki.data.Damage
import com.example.dndwiki.data.School
import com.example.dndwiki.data.SpellDetails

@Entity(tableName = "spell_details_table")
data class SpellDetailsDB(
    @PrimaryKey val index: String,
    val name: String,
    val level: Int,
    val duration: String,
    val casting_time: String,
    val damage: Damage? = null,
    val school: School,
    val classes: List<Classes>,
    val url: String,
    val desc: List<String>,
)

fun SpellDetailsDB.toSpellDetails() = SpellDetails(
    index, name, level, duration, desc, url, casting_time, damage, school, classes
)

fun SpellDetails.toSpellDetailsDB() = SpellDetailsDB(
    index, name, level, duration, casting_time, damage, school, classes, url, desc
)

