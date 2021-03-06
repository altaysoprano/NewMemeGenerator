package com.example.newmemegenerator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = white800,
    background = white,
    onBackground = white900,
    surface = white600,
    onSurface = white50,
    secondary = white700
)

private val LightColorPalette = lightColors(
    primary = Color.LightGray,
    background = white900,
    onBackground = white50,
    surface = white600,
    onSurface = white50,
    secondary = white700
)

@Composable
fun NewMemeGeneratorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}