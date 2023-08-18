package dev.giuliopime.jetpackdemos

import android.app.Application
import timber.log.Timber

class JetpackDemosApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // "There are no Tree implementations installed by default because every time you log in production, a puppy dies."
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}