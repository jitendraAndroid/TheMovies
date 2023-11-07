package com.jkhetle.themovies

import android.app.Application
import android.util.Log

class TheMoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AUTH_TOKEN = stringFromJNI()
        Log.d(TAG, "Coming inside onCreate :")
    }
    external fun stringFromJNI(): String

    companion object {
        lateinit var AUTH_TOKEN: String
        const val TAG = "TheMoviesApplication"
        init {
            System.loadLibrary("native-lib")
        }
    }
}
