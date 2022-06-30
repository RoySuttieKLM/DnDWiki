package com.example.dndwiki.repository

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun saveDate(saveDate: Long) {

        editor.apply {
            putLong("LAST_SAVE", saveDate)
        }.apply()
    }

    fun getLastSaveDate(): Long {
        return preferences.getLong("LAST_SAVE", 0L)
    }
}