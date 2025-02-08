package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.domain.repositories.OnboardingRepository

class GetOnboardingStatusUseCase(
    private val onboardingRepository: OnboardingRepository
) {
    operator fun invoke() = onboardingRepository.isOnboardingCompleted()
}