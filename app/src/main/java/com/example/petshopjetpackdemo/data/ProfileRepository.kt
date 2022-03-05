package com.example.petshopjetpackdemo.data

import com.example.petshopjetpackdemo.model.ProfileSection

object ProfileRepository {
    fun getSections(): List<ProfileSection> = profileSectionsCollections
}

private val profileSectionsCollections = listOf(
    ProfileSection(
        routeName = "orders",
        name = "Мои заказы",
        imageUrl = "https://cdn-icons-png.flaticon.com/512/103/103725.png",
        color = "#35B395"
    ),
    ProfileSection(
        routeName = "my_data",
        name = "Мои данные",
        color = "#66B8D7",
        imageUrl = "https://www.freeiconspng.com/thumbs/computer-user-icon/computer-user-icon-28.png"
    )
)