package com.example.dndwiki.diModule

import android.app.Application
import androidx.room.Room
import com.example.dndwiki.database.AppDatabase
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.database.spellDetails.SpellDetailsDao
import com.example.dndwiki.database.spellDetails.TypeConverter
import com.example.dndwiki.database.spells.SpellsDao
import com.example.dndwiki.network.ApiSource
import com.example.dndwiki.repository.SpellRepository
import com.google.gson.Gson
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val DnDModule = module {

    single { ApiSource() }
    single { DBSource(get(), get()) }

}

val repositoryModule = module {
    fun provideRepository(api: ApiSource, dao: DBSource): SpellRepository {
        return SpellRepository(api, dao)
    }

    single { provideRepository(get(), get()) }
}

val databaseModule = module {

    single { Gson() }

    single { TypeConverter(get()) }

    fun provideTypeConverter(gson: Gson): TypeConverter {
        return TypeConverter(gson)
    }

    fun provideDataBase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "Spell_Finder_Database")
            .fallbackToDestructiveMigration()
            .addTypeConverter(provideTypeConverter(Gson()))
            .build()
    }

    fun provideSpellsDao(database: AppDatabase): SpellsDao {
        return database.spellsDao()
    }

    fun provideSpellDetailsDao(database: AppDatabase): SpellDetailsDao {
        return database.spellDetailsDao()
    }

    single { provideDataBase(androidApplication()) }

    single { provideSpellsDao(get()) }

    single { provideSpellDetailsDao(get()) }

}
