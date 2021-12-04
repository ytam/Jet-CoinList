package io.github.ytam.jetcoinlist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightThemeColors = lightColors(
    primary = gray50,
    primaryVariant = gray50,
    onPrimary = gray50,
    secondary = black,
    secondaryVariant = teal700,
    onSecondary = white,
    surface = white,
    onSurface = black,
    background = white,
    onBackground = black
)

private val darkThemeColors = darkColors(
    primary = black,
    primaryVariant = black,
    onPrimary = white,
    secondary = teal200,
    secondaryVariant = teal200,
    onSecondary = black,
    surface = black,
    onSurface = white,
    background = gray950,
    onBackground = gray950
)

@Composable
fun CoinListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = if (darkTheme) darkThemeColors else lightThemeColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
