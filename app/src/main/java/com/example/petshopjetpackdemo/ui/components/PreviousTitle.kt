package com.example.petshopjetpackdemo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshopjetpackdemo.R
import com.example.petshopjetpackdemo.ui.theme.BlueLinkText
import com.example.petshopjetpackdemo.ui.theme.montserratFontFamily

@Composable
fun PreviousTitle(text: String, onClickAction: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .clickable { onClickAction.invoke() }
    ) {
        Icon(painter = painterResource(id = R.drawable.icon_arrow_back_blue), contentDescription = null, tint = BlueLinkText)
        Text(
            text = text,
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
            color = BlueLinkText,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}