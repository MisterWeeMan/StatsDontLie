package com.example.statsdontlie

import android.app.Application
import timber.log.Timber

class StatsDontLieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}