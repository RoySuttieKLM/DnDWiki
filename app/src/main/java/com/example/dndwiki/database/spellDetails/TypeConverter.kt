package com.example.dndwiki.database.spellDetails

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dndwiki.data.Classes
import com.example.dndwiki.data.Damage
import com.example.dndwiki.data.School
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class TypeConverter {

    @TypeConverter
    fun stringToSchool(value: String?): School? {
        return Gson().fromJson(value, School::class.java)
    }

    @TypeConverter
    fun schoolToString(school: School?): String {
        return Gson().toJson(school)
    }

    @TypeConverter
    fun stringToDamageType(value: String?): Damage? {
        return Gson().fromJson(value, Damage::class.java)
    }

    @TypeConverter
    fun damageTypeToString(damage: Damage?): String? {
        return Gson().toJson(damage)
    }

    @TypeConverter
    fun listToDesc(value: String?): List<String> {
        val itemType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, itemType)
    }

    @TypeConverter
    fun descToList(desc: List<String>?): String? {
        return Gson().toJson(desc)
    }

    @TypeConverter
    fun listToClasses(value: String?): List<Classes> {
        val itemType = object : TypeToken<List<Classes>>() {}.type
        return Gson().fromJson(value, itemType)
    }

    @TypeConverter
    fun classesToList(classes: List<Classes>?): String {
        return Gson().toJson(classes)
    }
}