package me.krasnova.common.ui

enum class BottomBarItems(
    val title: String,
    val iconRes: String,
    val route: String
) {
    CATALOG("Каталог", "icon_catalog", "main/catalog"),
    AUTO_ORDER("Автозаказы", "icon_autoorder", "main/autoOrder"),
    CART("Корзина", "icon_cart", "main/cart"),
    MORE("Ещё", "icon_more", "main/more")
}