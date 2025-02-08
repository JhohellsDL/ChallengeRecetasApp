package com.example.challengerecetasapp.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengerecetasapp.R
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.models.getRecipeLevel
import com.example.challengerecetasapp.domain.repositories.getImageById
import com.example.challengerecetasapp.ui.theme.EasyRecipesTheme
import com.example.challengerecetasapp.ui.theme.Typography

@Composable
fun RecipeItem(
    recipe: Recipe,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit,
    onClickItem: () -> Unit
) {
    EasyRecipesTheme {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { onClickItem() },
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier.background(colorScheme.surface),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(112.dp)
                        .padding(12.dp)
                        .shadow(6.dp, shape = RoundedCornerShape(56.dp), clip = true),
                    shape = RoundedCornerShape(56.dp),
                    elevation = CardDefaults.elevatedCardElevation(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Image(
                        painter = painterResource(id = getImageById(recipe.id)),
                        contentDescription = "Imagen de la receta",
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier,
                    ) {
                        Text(
                            text = recipe.title,
                            style = Typography.titleMedium,
                            color = colorScheme.onPrimary,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Text(
                            text = recipe.shortDescription,
                            style = Typography.bodyMedium,
                            color = colorScheme.onSecondary,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(12.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_access_time_24),
                                contentDescription = "Favorite",
                            )
                            Text(
                                text = "${recipe.totalTime} min.",
                                style = Typography.bodySmall,
                                color = colorScheme.onPrimary,
                                modifier = Modifier
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(12.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_local_fire),
                                contentDescription = "Favorite",
                            )
                            Text(
                                text = getRecipeLevel(recipe.difficulty).name,
                                style = Typography.bodySmall,
                                color = colorScheme.onPrimary,
                                modifier = Modifier
                            )
                        }
                        IconButton(onClick = onFavoriteToggle) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                                tint = if (isFavorite) colorScheme.error else colorScheme.onSecondary
                            )
                        }
                    }

                }
            }
        }
    }
}


@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun RecipeItemPreviewDark() {
    EasyRecipesTheme(darkTheme = true) {
        RecipeItem(
            recipe = Recipe(1, "Recipe title", shortDescription = "Short description"),
            isFavorite = false,
            onFavoriteToggle = { },
            onClickItem = { }
        )
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun RecipeItemPreviewLight() {
    EasyRecipesTheme(darkTheme = false) {
        RecipeItem(
            recipe = Recipe(1, "Recipe title", shortDescription = "Short description"),
            isFavorite = true,
            onFavoriteToggle = { },
            onClickItem = { }
        )
    }
}