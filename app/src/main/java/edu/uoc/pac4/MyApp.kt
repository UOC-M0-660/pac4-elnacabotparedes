package edu.uoc.pac4

import android.app.Application
import edu.uoc.pac4.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp: Application()
{
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            module { listOf(dataModule) }
        }
    }
}