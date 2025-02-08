package com.example.challengerecetasapp.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.challengerecetasapp.navigation.AppNavigator
import com.example.challengerecetasapp.navigation.RecipeRoute
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun OnboardingScreen(
    navController: NavHostController,
    onboardingViewModel: OnboardingViewModel = koinViewModel(),
    navigator: AppNavigator = koinInject()
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { onboardingPages.size }
    )
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPageContent(page = onboardingPages[page])
        }

        Button(
            onClick = {
                if (pagerState.currentPage == onboardingPages.lastIndex) {
                    onboardingViewModel.setOnboardingCompleted()
                    navigator.navigateToHome(navController, RecipeRoute.Onboarding)
                } else {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(
                text = if (pagerState.currentPage == onboardingPages.lastIndex) "Comenzar" else "Siguiente"
            )
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = page.title,
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

data class OnboardingPage(val title: String, val description: String)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Bienvenido al Recetario",
        description = "Aquí encontrarás recetas deliciosas."
    ),
    OnboardingPage(
        title = "Encuentra Recetas",
        description = "Busca y filtra recetas fácilmente."
    ),
    OnboardingPage(
        title = "Guarda tus favoritas",
        description = "Accede rápido a tus recetas preferidas."
    )
)

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(navController = rememberNavController())
}
