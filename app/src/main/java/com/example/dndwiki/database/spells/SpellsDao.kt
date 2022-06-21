package com.example.dndwiki.database.spells

import androidx.room.*

@Dao
interface SpellsDao {

    @Query("SELECT * FROM spells_table")
    suspend fun getAll(): List<SpellsDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spells: List<SpellsDB>)

    @Delete
    suspend fun delete(spells: List<SpellsDB>)
}