package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.domain.repositories.OnboardingRepository

class SetOnboardingCompletedUseCase(
    private val onboardingRepository: OnboardingRepository
) {
    suspend operator fun invoke(completed: Boolean) =
        onboardingRepository.setOnboardingCompleted(completed)
}
