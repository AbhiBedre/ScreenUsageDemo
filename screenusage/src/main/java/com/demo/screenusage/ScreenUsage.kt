package com.demo.screenusage

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object ScreenUsage {
    var startTime: Long = System.currentTimeMillis()
    var elapsedTime: Long = 0
    /*val pref: SharedPreferences? =
        MyAppLibrary.context?.getSharedPreferences("MyPref", MODE_PRIVATE) ?: null
    var editor = pref?.edit()*/

    const val PREFERENCE_NAME = "PREFERENCE_DATA"
    private var sharedpreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    fun setPref(context: Context) {
        sharedpreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        editor = sharedpreferences?.edit()
    }

    fun screenOn(simpleName: String) {
        elapsedTime = 0
        startTime = System.currentTimeMillis()
    }

    fun screenOff(simpleName: String) {
        elapsedTime += (System.currentTimeMillis() - startTime)
        editor?.putLong(
            simpleName,
            (elapsedTime + (sharedpreferences?.getLong(simpleName, 0) ?: 0))
        )
        editor?.apply()
    }

    fun retrieveScreenUsage(): List<Pair<String, String>> {
        val allEntries: Map<String, *>? = ScreenUsage.sharedpreferences?.all
        val sharedPrefList = arrayListOf<Pair<String, String>>()
        if (allEntries != null) {
            val sharedPreferenceIds = ScreenUsage.sharedpreferences?.all
            sharedPreferenceIds?.forEach {
                val millis = ScreenUsage.sharedpreferences?.getLong(it.key, 0) ?: 0
                val seconds = (millis / 1000) % 60
                val minutes = ((millis / 1000) / 60) % 60
                val hours = ((millis / 1000) / 60) / 60
                sharedPrefList.add(
                    Pair(
                        it.key, String.format(
                            "%02dh : %02dm : %02ds",
                            hours,
                            minutes,
                            seconds
                        )
                    )
                )
            }
        }
        return sharedPrefList
    }
}