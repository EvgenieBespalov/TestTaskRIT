package com.example.testtaskrit

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    val SELECT_SCREEN = "SELECT_SCREEN"
    val CUSTOM_PREF_NAME = "settings"

    fun customPreference(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.settings
        get() = getString(SELECT_SCREEN, null)
        set(value) {
            editMe {
                it.putString(SELECT_SCREEN, value)
            }
        }

    var SharedPreferences.clearValues
        get() = { }
        set(value) {
            editMe {
                it.clear()
            }
        }
}