package me.krasnova.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.loadXmlImageVector
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.xml.sax.InputSource

@Composable
actual fun Font(name: String, res: String, weight: FontWeight, style: FontStyle): Font =
    androidx.compose.ui.text.platform.Font("font/$res.ttf", weight, style)

@Composable
actual fun loadXmlIcon(name: String): ImageVector =
    useResource("images/$name.xml") { stream ->
        loadXmlImageVector(InputSource(stream), LocalDensity.current)
    }

object ResString {
    val appName: String

    val bottomBarCatalogTitle: String
    val bottomBarCartTitle: String
    val bottomBarAutoOrderTitle: String
    val bottomBarMoreTitle: String

    val topBarPersonalAccountTitle: String
    val profileMyOrdersButtonTitle: String
    val profileMyInformationButtonTitle: String
    val ordersEmptyTitle: String
    val ordersEmptyButtonTitle: String

    init {
        if (System.getProperty("user.language").equals("ru")) {
            appName = "Petshop JetpackDemo"
            bottomBarCatalogTitle = "Каталог"
            bottomBarCartTitle = "Корзина"
            bottomBarAutoOrderTitle = "Автозаказы"
            bottomBarMoreTitle = "Ещё"
            topBarPersonalAccountTitle = "Личный кабинет"
            profileMyOrdersButtonTitle = "Мои заказы"
            profileMyInformationButtonTitle = "Мои данные"
            ordersEmptyTitle = "Каким будет ваш первый заказ?"
            ordersEmptyButtonTitle = "Вперёд, за покупками!"
        } else {
            appName = "Petshop JetpackDemo"
            bottomBarCatalogTitle = "Catalog"
            bottomBarCartTitle = "Cart"
            bottomBarAutoOrderTitle = "Auto orders"
            bottomBarMoreTitle = "More"
            topBarPersonalAccountTitle = "Profile"
            profileMyOrdersButtonTitle = "My orders"
            profileMyInformationButtonTitle = "My information"
            ordersEmptyTitle = "What will be your first order?"
            ordersEmptyButtonTitle = "Go shopping!"
        }
    }
}