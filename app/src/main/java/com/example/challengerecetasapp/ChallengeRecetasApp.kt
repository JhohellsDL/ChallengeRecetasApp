package com.example.challengerecetasapp

import android.app.Application
import com.example.challengerecetasapp.data.local.room.AppDatabase
import com.example.challengerecetasapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChallengeRecetasApp: Application() {
    lateinit var database: AppDatabase
    override fun onCreate() {
        super.onCreate()

        database = AppDatabase.getInstance(this)
        startKoin {
            androidContext(this@ChallengeRecetasApp)
            modules(appModule)
        }
    }
}