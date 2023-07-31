package com.joaquindev.jotacommerce.presentation.navigation.screen.client




open class ClientCategoryScreen(val route: String) {
    object ProductList : ClientCategoryScreen("client/category/products/list/{category}") {
        fun passCategory(category: String) = "client/category/products/list/${category}"
    }

    object ProductDetail : ClientCategoryScreen("client/category/detail/{product}") {
        fun passProduct(product: String) = "client/category/detail/${product}"
    }


}