package com.example.petshopjetpackdemo.model

import androidx.compose.runtime.Immutable

@Immutable
data class ProfileSection(
    val routeName: String,
    val name: String,
    val imageUrl: String,
    val color: String? = null
)

fun ProfileSection.toQuickCardData() = QuickCardData(
    title = name,
    imageUrl = imageUrl,
    color = color
)
