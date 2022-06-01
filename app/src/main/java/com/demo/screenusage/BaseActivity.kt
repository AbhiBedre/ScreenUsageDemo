package com.demo.screenusage

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {

    /*var startTime: Long = System.currentTimeMillis()
    var elapsedTime: Long = 0
    val pref: SharedPreferences? =
        MyApp.context?.getSharedPreferences("MyPref", MODE_PRIVATE) ?: null
    var editor = pref?.edit()*/

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    /*override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume: ${this.javaClass.simpleName}")
        elapsedTime = 0
        startTime = System.currentTimeMillis()
    }

    override fun onPause() {
        super.onPause()
        elapsedTime += (System.currentTimeMillis() - startTime)
        editor?.putLong(
            this.javaClass.simpleName,
            (elapsedTime + (pref?.getLong(this.javaClass.simpleName, 0) ?: 0))
        )
        editor?.apply()
    }*/
}