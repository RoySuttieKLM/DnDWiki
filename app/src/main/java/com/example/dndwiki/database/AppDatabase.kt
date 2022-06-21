package com.example.dndwiki.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dndwiki.database.spellDetails.SpellDetailsDB
import com.example.dndwiki.database.spellDetails.SpellDetailsDao
import com.example.dndwiki.database.spellDetails.TypeConverter
import com.example.dndwiki.database.spells.SpellsDB
import com.example.dndwiki.database.spells.SpellsDao

@Database(entities =
[SpellsDB::class, SpellDetailsDB::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun spellsDao(): SpellsDao
    abstract fun spellDetailsDao(): SpellDetailsDao
}