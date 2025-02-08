package com.example.challengerecetasapp.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengerecetasapp.R
import com.example.challengerecetasapp.domain.models.CategoryRecipe
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.models.getRecipeLevel
import com.example.challengerecetasapp.domain.repositories.getImageById
import com.example.challengerecetasapp.ui.components.RecipeItem
import com.example.challengerecetasapp.ui.theme.DarkBackground
import com.example.challengerecetasapp.ui.theme.DarkSurface
import com.example.challengerecetasapp.ui.theme.EasyRecipesTheme
import com.example.challengerecetasapp.ui.theme.OnSecondary
import com.example.challengerecetasapp.ui.theme.Typography
import com.example.challengerecetasapp.ui.theme.WarningYellow

@Composable
private fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                style = Typography.headlineMedium,
                color = colorScheme.onPrimary,
                modifier = Modifier,
                text = stringResource(R.string.hi)
            )
            Text(
                style = Typography.labelLarge,
                color = colorScheme.onSecondary,
                modifier = Modifier,
                text = stringResource(R.string.subtitle_home)
            )
        }
        Icon(
            modifier = Modifier.size(48.dp),
            imageVector = Icons.Default.AccountCircle,
            contentDescription = stringResource(R.string.favorite_description),
            tint = colorScheme.onPrimary
        )
    }
}

@Composable
private fun CardCurrentHome(
    recipe: Recipe,
    onRefresh: () -> Unit = { }
) {
    EasyRecipesTheme {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { },
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.elevatedCardElevation(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Image(
                    modifier = Modifier
                        .matchParentSize(),
                    painter = painterResource(id = getImageById(recipe.id)),
                    contentDescription = stringResource(R.string.image_recipe_description),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd),
                    onClick = onRefresh ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Add to favorites",
                        tint = DarkBackground
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 1f),
                                    Color.Black.copy(alpha = 0.5f),
                                    Color.Transparent
                                ),
                                startX = 0f,
                                endX = Float.POSITIVE_INFINITY
                            )
                        )
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 24.dp, end = 48.dp, bottom = 24.dp, top = 24.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.title_card_current),
                            style = Typography.titleLarge,
                            color = OnSecondary,
                            modifier = Modifier.wrapContentWidth()
                        )

                        Text(
                            text = recipe.title,
                            style = Typography.headlineSmall,
                            color = WarningYellow,
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(top = 16.dp)
                        )

                        Row(
                            modifier = Modifier.padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier.size(24.dp),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(WarningYellow)
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(16.dp)
                                            .align(Alignment.Center),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_access_time_24),
                                        contentDescription = stringResource(R.string.favorite_description),
                                        tint = DarkSurface
                                    )
                                }
                            }
                            Text(
                                text = stringResource(R.string.time_label, recipe.totalTime),
                                style = Typography.titleMedium,
                                color = WarningYellow,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 8.dp)
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                            Card(
                                modifier = Modifier.size(24.dp),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(WarningYellow)
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(16.dp)
                                            .align(Alignment.Center),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_local_fire),
                                        contentDescription = stringResource(R.string.favorite_description),
                                        tint = DarkSurface
                                    )
                                }
                            }
                            Text(
                                text = getRecipeLevel(recipe.difficulty).name,
                                style = Typography.titleMedium,
                                color = WarningYellow,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 8.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
private fun HomeListCategories(
    selectCategoryRecipe: CategoryRecipe? = null,
    onCategorySelected: (String) -> Unit = {}
) {
    val categories = CategoryRecipe.categories

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = Typography.headlineSmall,
            text = stringResource(R.string.title_categories),
            color = colorScheme.onPrimary
        )
        LazyRow {
            items(categories.size) { index ->
                CardCategory(
                    categories[index],
                    isSelected = categories[index] == selectCategoryRecipe,
                    onclickCard = { onCategorySelected(categories[index].name) }
                )
            }
        }
    }
}

@Composable
private fun CardCategory(
    category: CategoryRecipe,
    isSelected: Boolean = false,
    onclickCard: () -> Unit = {}
) {
    val backgroundColorCard = if (isSelected) WarningYellow else colorScheme.surface
    val colorText = if (isSelected) DarkSurface else colorScheme.onPrimary
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
            .clickable(onClick = { onclickCard() }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
    ) {
        Box(
            modifier = Modifier.background(backgroundColorCard)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            ) {
                Card(
                    modifier = Modifier,
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.elevatedCardElevation(4.dp),
                ) {
                    Image(
                        painter = painterResource(id = category.type.getImageResource()),
                        contentDescription = stringResource(R.string.image_recipe_description),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = category.nameFilter,
                    style = Typography.titleMedium,
                    color = colorText,
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    recipes: List<Recipe>,
    favorites: Set<Int>,
    randomRecipe: Recipe?,
    onFavoriteClick: (Int) -> Unit,
    navigatorClick: (Int) -> Unit,
    onRandomClick: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf<CategoryRecipe?>(CategoryRecipe.categories.first()) }
    val filteredRecipes = when {
        selectedCategory == null || selectedCategory == CategoryRecipe.categories.first() -> recipes
        else -> recipes.filter { it.categoryCode == selectedCategory?.name }
    }

    Column {
        HomeHeader()
        CardCurrentHome(
            recipe = randomRecipe ?: Recipe(),
            onRefresh = { onRandomClick() }
        )
        HomeListCategories(
            selectCategoryRecipe = selectedCategory,
            onCategorySelected = { category ->
                selectedCategory = if (category == selectedCategory?.name) {
                    CategoryRecipe.categories.first()
                } else {
                    CategoryRecipe.categories.find { it.name == category }
                }
            }
        )
        LazyColumn {
            items(filteredRecipes.size) { index ->
                val recipe = filteredRecipes[index]
                RecipeItem(
                    recipe = recipe,
                    isFavorite = recipe.id in favorites,
                    onFavoriteToggle = {
                        onFavoriteClick(recipe.id)
                    },
                    onClickItem = {
                        navigatorClick(recipe.id)
                    }
                )
            }
        }
    }
}


@Preview(
    name = "Dark Mode",
    showBackground = true,
    backgroundColor = 0xFF1E2025,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    backgroundColor = 0xFFE6E9E8,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeHeaderPreview() {
    EasyRecipesTheme {
        HomeHeader()
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    backgroundColor = 0xFF1E2025,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    backgroundColor = 0xFFE6E9E8,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun CardCurrentHomePreview() {
    EasyRecipesTheme {
        CardCurrentHome(
            recipe = Recipe(
                id = 1,
                title = "Galletas de maizena y Chocolate crujientes",
                description = "Descripción de la receta 1",
                imageUrl = "https://via.placeholder.com/150"
            )
        )
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    backgroundColor = 0xFF1E2025,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    backgroundColor = 0xFFE6E9E8,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeListCategoriesPreview() {
    EasyRecipesTheme {
        HomeListCategories()
    }
}


@Preview(
    name = "Dark Mode",
    showBackground = true,
    backgroundColor = 0xFF1E2025,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    backgroundColor = 0xFFE6E9E8,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeScreenPreview() {
    EasyRecipesTheme {
        HomeScreenContent(
            recipes = listOf(
                Recipe(
                    id = 1,
                    title = "Receta 1",
                    shortDescription = "Descripción de la receta 1",
                    description = "Descripción de la receta 1",
                    imageUrl = "https://via.placeholder.com/150"
                ),
                Recipe(
                    id = 2,
                    title = "Receta 2",
                    shortDescription = "Descripción de la receta 2",
                    description = "Descripción de la receta 2",
                    imageUrl = "https://via.placeholder.com/150"
                ),
                Recipe(
                    id = 3,
                    title = "Receta 3",
                    shortDescription = "Descripción de la receta 3",
                    description = "Descripción de la receta 3",
                    imageUrl = "https://via.placeholder.com/150"
                )
            ),
            randomRecipe = Recipe(
                id = 1,
                title = "Galletas de maizena y Chocolate crujientes",
                shortDescription = "Descripción de la receta 1",
                description = "Descripción de la receta 1",
                imageUrl = "https://via.placeholder.com/150"
            ),
            favorites = setOf(1, 3),
            onFavoriteClick = { },
            navigatorClick = { },
            onRandomClick = { }
        )
    }
}