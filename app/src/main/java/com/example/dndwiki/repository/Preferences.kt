package com.example.dndwiki.repository

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun saveData(saveDate: Long) {

        editor.apply {
            putLong("LONG_KEY", saveDate)
        }.apply()
    }

    fun getData(): Long {
        return preferences.getLong("LONG_KEY", 0L)
    }

    fun clearData() {
        editor.clear()
    }
}