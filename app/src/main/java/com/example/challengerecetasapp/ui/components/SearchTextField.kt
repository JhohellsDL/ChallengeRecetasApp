package com.example.challengerecetasapp.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.challengerecetasapp.ui.theme.WarningYellow

@Composable
fun SearchTextField(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        modifier = modifier,
        placeholder = {
            Text(
                text = "Buscar recetas...",
                color = colorScheme.onPrimary
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Ícono de búsqueda",
                tint = Color.Gray
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(
                    onClick = { onSearchQueryChange("") }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Borrar búsqueda",
                        tint = WarningYellow
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = colorScheme.onPrimary,
            unfocusedTextColor = colorScheme.onPrimary,
            disabledTextColor = Color.Gray,
            focusedContainerColor = colorScheme.surface,
            unfocusedContainerColor = colorScheme.surface,
            disabledContainerColor = colorScheme.tertiary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}