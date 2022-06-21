package com.example.dndwiki.database.spellDetails

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dndwiki.data.Classes
import com.example.dndwiki.data.Damage
import com.example.dndwiki.data.School

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