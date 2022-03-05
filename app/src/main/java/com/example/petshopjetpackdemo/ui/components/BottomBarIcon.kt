package com.example.petshopjetpackdemo.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petshopjetpackdemo.ui.theme.InactiveGreyIcon

@Composable
fun BottomBarIcon(
    @DrawableRes iconResourceId: Int,
    @StringRes titleResourceId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(22.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResourceId),
            contentDescription = stringResource(titleResourceId),
            tint = InactiveGreyIcon,
            modifier = Modifier.align(Alignment.Center)
        )
    }


}