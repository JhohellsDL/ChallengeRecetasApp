package com.example.challengerecetasapp.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)

fun createDataStore(context: Context): DataStore<Preferences>{
    return context.dataStore
}