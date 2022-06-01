package com.demo.screenusage

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //  instance = this;
        mContext = applicationContext
    }

    companion object {
        //private static MyApp instance;
        @SuppressLint("StaticFieldLeak")
        private var mContext: Context? = null
        @SuppressLint("StaticFieldLeak")
        val instance: MyApp = MyApp()

        //  return instance.getApplicationContext();
        val context: Context?
            get() =//  return instance.getApplicationContext();
                mContext
    }
}
