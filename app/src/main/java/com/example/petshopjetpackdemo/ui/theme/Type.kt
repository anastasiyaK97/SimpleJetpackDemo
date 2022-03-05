package com.example.petshopjetpackdemo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.petshopjetpackdemo.R

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = 10.sp,
        color = GreyText
    ),
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        fontSize = 20.sp,
        color = BlackText
    ),
    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 15.sp,
        color = BlackText
    )
)

val montserratFontFamily = FontFamily(
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val robotoFontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium)
)
