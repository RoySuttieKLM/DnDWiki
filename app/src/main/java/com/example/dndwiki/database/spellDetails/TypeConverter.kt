package com.example.dndwiki.database.spellDetails

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dndwiki.data.Classes
import com.example.dndwiki.data.Damage
import com.example.dndwiki.data.School
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class TypeConverter(
    private val gson: Gson,
) {


    @TypeConverter
    fun stringToSchool(value: String): School {
        return gson.fromJson(value, School::class.java)
    }

    @TypeConverter
    fun schoolToString(school: School): String {
        return gson.toJson(school)
    }

    @TypeConverter
    fun stringToDamageType(value: String?): Damage? {
        return gson.fromJson(value, Damage::class.java)
    }

    @TypeConverter
    fun damageTypeToString(damage: Damage?): String? {
        return gson.toJson(damage)
    }

    @TypeConverter
    fun listToDesc(value: String): List<String> {
        val itemType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, itemType)
    }

    @TypeConverter
    fun descToList(desc: List<String>): String {
        return gson.toJson(desc)
    }

    @TypeConverter
    fun listToClasses(value: String): List<Classes> {
        val itemType = object : TypeToken<List<Classes>>() {}.type
        return gson.fromJson(value, itemType)
    }

    @TypeConverter
    fun classesToList(classes: List<Classes>): String {
        return gson.toJson(classes)
    }
}