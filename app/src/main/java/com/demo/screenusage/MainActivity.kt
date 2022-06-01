package com.demo.screenusage

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_screen1.setOnClickListener {
            startActivity(Intent(this, Screen1Activity::class.java))
        }

        btn_screen2.setOnClickListener {
            startActivity(Intent(this, Screen2Activity::class.java))
        }

        val am = this.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val taskInfo = am.getRunningTasks(1)
        val componentInfo = taskInfo[0].topActivity
        Log.d(
            "TAG",
            "CURRENT Activity ::" + taskInfo[0].topActivity!!.shortClassName + "   Package Name :  " + componentInfo!!.packageName
        )

        Log.i("TAG", "onCreate: ${this.javaClass.name}")
        showScreenUsage()
    }

    private fun showScreenUsage() {
        val allEntries: Map<String, *>? = ScreenUsage.pref?.all
        if (allEntries != null) {
            Log.i("TAG", "showScreenUsage: $allEntries")
            val sharedPreferenceIds = ScreenUsage.pref?.all?.map { it.key }
            sharedPreferenceIds?.forEach {
                val millis = ScreenUsage.pref?.getLong(it, 0) ?: 0
                val minutes = (millis / 1000) / 60
                val seconds = (millis / 1000) % 60
                Log.i("TAG", "showScreenUsage: $minutes $seconds")
                Log.i("TAG", "showScreenUsage: $it")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        com.demo.screenusage.ScreenUsage.screenOn(this.javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG", "onPause: ${this.javaClass.simpleName}")
        com.demo.screenusage.ScreenUsage.screenOff(this.javaClass.simpleName)
    }
}