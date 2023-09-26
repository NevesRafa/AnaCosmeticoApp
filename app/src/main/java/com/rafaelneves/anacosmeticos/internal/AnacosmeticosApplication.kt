package com.rafaelneves.anacosmeticos.internal

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnacosmeticosApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AnacosmeticosApplication)

            modules(DIModules.all())
        }

    }
}