package me.krasnova.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.krasnova.common.theme.*

private val LightColorPalette = PetshopColors(
    uiBackground = White,
    uiBorder = White,
    textPrimary = Black,
    textSecondary = Black,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    isDark = false
)

private val DarkColorPalette = PetshopColors(
    uiBackground = Black,
    uiBorder = Black,
    textPrimary = White,
    textSecondary = White,
    surface = Black,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
    isDark = true
)

@Composable
fun PetshopJetpackDemoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = TopBarBackground
    )

    ProvidePetshopColors(colors) {
        MaterialTheme(
            colors = materialColors(colors),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}

object PetshopTheme {
    val colors: PetshopColors
        @Composable
        get() = LocalPetshopColors.current
}

@Composable
fun ProvidePetshopColors(
    colors: PetshopColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalPetshopColors provides colorPalette, content = content)
}

private val LocalPetshopColors = staticCompositionLocalOf<PetshopColors> {
    error("No PetshopColorPalette provided")
}

@Stable
class PetshopColors(
    uiBackground: Color,
    uiBorder: Color,
    textPrimary: Color,
    textSecondary: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    isDark: Boolean = false
) {
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: PetshopColors) {
        uiBackground = other.uiBackground
        uiBorder = other.uiBorder
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        surface = other.surface
        onPrimary = other.onPrimary
        onSecondary = other.onSecondary
        onBackground = other.onBackground
        onSurface = other.onSurface
        isDark = other.isDark
    }

    fun copy(): PetshopColors = PetshopColors(
        uiBackground = uiBackground,
        uiBorder = uiBorder,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        surface = surface,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        onBackground = onBackground,
        onSurface = onSurface,
        isDark = isDark
    )
}

fun materialColors(
    colors: PetshopColors
) = Colors(
    primary = colors.textPrimary,
    primaryVariant = colors.textPrimary,
    secondary = colors.textSecondary,
    secondaryVariant = colors.textSecondary,
    background = colors.uiBackground,
    surface = colors.surface,
    onPrimary = colors.onPrimary,
    onSecondary = colors.onSecondary,
    onBackground = colors.onBackground,
    onSurface = colors.onSurface,
    isLight = colors.isDark,
    error = ErrorRed,
    onError = ErrorRed
)
