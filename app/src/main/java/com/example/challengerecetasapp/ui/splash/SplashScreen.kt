package com.example.challengerecetasapp.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.challengerecetasapp.navigation.AppNavigator
import com.example.challengerecetasapp.navigation.RecipeRoute
import com.example.challengerecetasapp.ui.onboarding.OnboardingViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun SplashScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel = koinViewModel(),
    navigator: AppNavigator = koinInject()
) {
    val onboardingCompleted by onboardingViewModel.onboardingCompleted.collectAsState(initial = false)

    LaunchedEffect(Unit) {
        delay(2000)
        if (onboardingCompleted) navigator.navigateToHome(navController, RecipeRoute.Splash)
        else navigator.navigateToOnboarding(navController)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Splash Screen")
    }
}