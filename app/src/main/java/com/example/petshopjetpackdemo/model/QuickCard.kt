package com.example.petshopjetpackdemo.model

import androidx.compose.runtime.Stable

@Stable
data class QuickCard(
    val quickCardData: QuickCardData,
    val clickAction: () -> Unit,
)