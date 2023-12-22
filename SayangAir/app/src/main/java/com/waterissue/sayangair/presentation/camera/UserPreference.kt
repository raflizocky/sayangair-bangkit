package com.waterissue.sayangair.presentation.camera

import android.content.Context
import android.content.SharedPreferences

object UserPreference{

    private val PREF_NAME = "UserPreference"
    private val SESSION = "session"

    fun init(context: Context, name: String): SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    private fun preferenceEditor(context: Context): SharedPreferences.Editor {
        val sharedPref = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        return sharedPref.edit()
    }

    fun getEmail(context: Context): String? {
        val sharedPref = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        return sharedPref.getString("email", null)
    }
    fun saveUserInfo(email: String, context: Context) {
        val editor = preferenceEditor(context)

        editor.putString("email", email)
        editor.apply()
    }
}
