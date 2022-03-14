package me.krasnova.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import me.krasnova.common.Font

object Fonts {
    @Composable
    fun montserrat() = FontFamily(
        Font(
            "Montserrat Bold",
            "montserrat_bold",
            FontWeight.Bold,
            FontStyle.Normal
        ),
        Font(
            "Montserrat Semi Bold",
            "montserrat_semi_bold",
            FontWeight.SemiBold,
            FontStyle.Normal
        )
    )

    @Composable
    fun roboto() = FontFamily(
        Font(
            "Roboto Medium",
            "roboto_medium",
            FontWeight.Medium,
            FontStyle.Normal
        ),
        Font(
            "Roboto Regular",
            "roboto_regular",
            FontWeight.Normal,
            FontStyle.Normal
        )
    )
}