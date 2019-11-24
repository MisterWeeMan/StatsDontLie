package com.mattiabano.statsdontlie

import android.app.Application
import timber.log.Timber

/**
 * Custom application object
 */
class StatsDontLieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Timber (logger) activation
        Timber.plant(Timber.DebugTree())
    }
}