package com.example.dndwiki.database.spellDetails

import androidx.room.*

@Dao
interface SpellDetailsDao {

    @Query("SELECT * FROM spell_details_table WHERE `index` = :index")
    suspend fun findByIndex(index: String): SpellDetailsDB

    @Query("SELECT * FROM spell_details_table")
    suspend fun getAll(): List<SpellDetailsDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spellDetails: SpellDetailsDB)

    @Update
    suspend fun update(spellDetails: List<SpellDetailsDB>)

    @Delete
    suspend fun delete(spellDetails: List<SpellDetailsDB>)

}