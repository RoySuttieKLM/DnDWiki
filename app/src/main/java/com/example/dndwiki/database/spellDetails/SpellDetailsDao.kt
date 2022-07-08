package com.example.dndwiki.database.spellDetails

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SpellDetailsDao {

    @Query("SELECT * FROM spell_details_table WHERE `index` = :index")
    suspend fun findByIndex(index: String): SpellDetailsDB

    @Query("SELECT * FROM spell_details_table")
    suspend fun getAll(): List<SpellDetailsDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(allSpellDetails: List<SpellDetailsDB>)

}