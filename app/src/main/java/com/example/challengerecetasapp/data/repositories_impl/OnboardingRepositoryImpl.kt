package com.example.challengerecetasapp.data.repositories_impl

import com.example.challengerecetasapp.data.local.DataStoreManager
import com.example.challengerecetasapp.domain.repositories.OnboardingRepository
import kotlinx.coroutines.flow.Flow

class OnboardingRepositoryImpl(
    private val dataStoreManager: DataStoreManager
): OnboardingRepository {
    override fun isOnboardingCompleted(): Flow<Boolean> {
        return dataStoreManager.onboardingCompletedFlow
    }

    override suspend fun setOnboardingCompleted(completed: Boolean) {
        dataStoreManager.markOnboardingCompleted(completed)
    }
}