package com.example.dndwiki.database.spells

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spells_table")
data class SpellsDB (
    @PrimaryKey val index: String,

    val name: String,
)
