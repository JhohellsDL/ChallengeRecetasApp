package com.example.challengerecetasapp.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val dataStore: DataStore<Preferences>) {

    companion object {
        private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
    }

    val onboardingCompletedFlow: Flow<Boolean> = dataStore.data.map {
        it[ONBOARDING_COMPLETED_KEY] == true
    }

    suspend fun markOnboardingCompleted(completed: Boolean) {
        try {
            dataStore.edit {
                if (it[ONBOARDING_COMPLETED_KEY]?.equals(completed) != true) it[ONBOARDING_COMPLETED_KEY] =
                    completed
            }
        } catch (_: Exception) {
            throw IOException("Error updating onboarding completed status")
        }
    }

}