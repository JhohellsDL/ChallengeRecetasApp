package com.example.challengerecetasapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.repositories.getImageById
import com.example.challengerecetasapp.ui.components.RecipeTopAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    viewModel: DetailViewModel = koinViewModel(),
    recipeId: Int,
    isFavorite: Boolean = false
) {

    LaunchedEffect(recipeId) {
        viewModel.loadRecipeById(recipeId)
    }

    val state by viewModel.state.collectAsState()

    when (state) {
        is DetailState.Loading -> Text("Cargando receta...")
        is DetailState.Success -> RecipeContent(
            recipe = (state as DetailState.Success).recipe,
            navController = navController
        )

        is DetailState.Error -> Text((state as DetailState.Error).message)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeContent(recipe: Recipe, navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            RecipeTopAppBar(
                title = recipe.title,
                onBack = { navController.popBackStack() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    navController.navigate("map/${recipe.latitude}/${recipe.longitude}")
                }
            ) {
                Icon(Icons.Default.LocationOn, contentDescription = "Ver en el mapa")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = getImageById(recipe.id)),
                contentDescription = "Imagen de la receta",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row { Text("Origen: ${recipe.createdAt}", modifier = Modifier.padding(start = 16.dp)) }
            Text(
                text = "Descripción:",
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
            Text(
                text = recipe.description,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
            )

            RecipeDetailSection(
                title = "Ingredientes",
                items = recipe.ingredients
            )
            RecipeDetailSection(
                title = "Pasos",
                items = recipe.steps
            )

        }
    }

}

@Composable
fun RecipeDetailSection(title: String, items: List<String>) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        items.forEach { item ->
            Text(
                text = "• $item",
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    RecipeContent(
        recipe = Recipe(
            id = 1,
            title = "Receta de prueba",
            description = "Descripción de la receta de prueba",
            ingredients = listOf("Ingrediente 1", "Ingrediente 2"),
            steps = listOf("Paso 1", "Paso 2"),
        ),
        rememberNavController()
    )
}