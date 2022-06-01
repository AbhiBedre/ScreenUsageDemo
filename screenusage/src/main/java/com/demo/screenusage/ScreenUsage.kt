package com.demo.screenusage

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object ScreenUsage {
    var startTime: Long = System.currentTimeMillis()
    var elapsedTime: Long = 0
    val pref: SharedPreferences? =
        MyAppLibrary.context?.getSharedPreferences("MyPref", MODE_PRIVATE) ?: null
    var editor = pref?.edit()

    fun screenOn(simpleName: String) {
        elapsedTime = 0
        startTime = System.currentTimeMillis()
    }

    fun screenOff(simpleName: String) {
        elapsedTime += (System.currentTimeMillis() - startTime)
        editor?.putLong(
            simpleName,
            (elapsedTime + (pref?.getLong(simpleName, 0) ?: 0))
        )
        editor?.apply()
    }
}