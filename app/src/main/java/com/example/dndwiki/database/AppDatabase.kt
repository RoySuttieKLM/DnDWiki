package com.example.dndwiki.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dndwiki.database.spellDetails.SpellDetailsDB
import com.example.dndwiki.database.spellDetails.SpellDetailsDao
import com.example.dndwiki.database.spellDetails.TypeConverter

@Database(entities =
[SpellDetailsDB::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun spellDetailsDao(): SpellDetailsDao
}