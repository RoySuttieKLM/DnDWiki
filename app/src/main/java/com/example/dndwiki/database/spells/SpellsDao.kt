package com.example.dndwiki.database.spells

import androidx.room.*

@Dao

interface SpellsDao {

    @Query("SELECT * FROM spells_table")
    suspend fun getAll(): List<SpellsDB>

    @Query("SELECT * FROM spells_table WHERE `index` IN (:index)")
    suspend fun loadAllByIndex(index: String): List<SpellsDB>

    @Query("SELECT * FROM spells_table WHERE name LIKE :name")
    suspend fun findByName(name: String): List<SpellsDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spells: List<SpellsDB>)

    @Delete
    suspend fun delete(spells: List<SpellsDB>)
}