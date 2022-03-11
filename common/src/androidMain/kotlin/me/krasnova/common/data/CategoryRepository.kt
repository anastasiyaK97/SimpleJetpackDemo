package me.krasnova.common.data

import androidx.compose.runtime.Immutable
import me.krasnova.common.model.QuickCardData

object CategoryRepository {
    fun getCategories(): List<Category> = categoryCollections
}

@Immutable
data class Category(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val color: String? = null
)

fun Category.toQuickCardData() = QuickCardData(
    title = name,
    imageUrl = imageUrl,
    color = color
)

private val categoryCollections = listOf(
    Category(
        id = 0L,
        name = "Сухой корм для кошек",
        imageUrl = "https://cdn-icons-png.flaticon.com/512/103/103725.png",
        color = "#FF934D"
    ),
    Category(
        id = 1L,
        name = "Игрушки для кошек",
        imageUrl = "",
        color = "#A889B8"
    ),
    Category(
        id = 2L,
        name = "Игрушки для собак",
        imageUrl = "https://cdn-icons-png.flaticon.com/512/103/103725.png",
        color = "#A889B8"
    ),
    Category(
        id = 3L,
        name = "Сухой корм для собак",
        imageUrl = "https://cdn-icons-png.flaticon.com/512/103/103725.png",
        color = "#6299CB"
    )
)