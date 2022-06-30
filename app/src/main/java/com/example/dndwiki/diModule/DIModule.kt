package com.example.dndwiki.diModule

import android.app.Application
import androidx.room.Room
import com.example.dndwiki.database.AppDatabase
import com.example.dndwiki.database.DBSource
import com.example.dndwiki.database.spellDetails.SpellDetailsDao
import com.example.dndwiki.database.spellDetails.TypeConverter
//import com.example.dndwiki.database.spells.SpellsDao
import com.example.dndwiki.network.ApiSource
import com.example.dndwiki.repository.Preferences
import com.example.dndwiki.repository.SpellRepository
import com.google.gson.Gson
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val DnDModule = module {

    single { ApiSource() }
    single { DBSource(get()) }

}

val repositoryModule = module {
    fun provideRepository(api: ApiSource, dao: DBSource, pref: Preferences): SpellRepository {
        return SpellRepository(api, dao, pref)
    }

    single { Preferences(get()) }
    single { provideRepository(get(), get(), get()) }
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

    fun provideSpellDetailsDao(database: AppDatabase): SpellDetailsDao {
        return database.spellDetailsDao()
    }

    single { provideDataBase(androidApplication()) }

    single { provideSpellDetailsDao(get()) }

}
