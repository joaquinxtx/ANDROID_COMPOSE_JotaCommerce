package com.joaquindev.jotacommerce.presentation.navigation.screen.client




open class ClientProductScreen(val route: String) {
    object ProductDetail : ClientProductScreen("client/products/detail/{product}") {
        fun passProduct(product: String) = "client/products/detail/${product}"
    }


}