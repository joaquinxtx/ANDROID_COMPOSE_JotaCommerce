package com.joaquindev.jotacommerce.presentation.navigation.screen.client




open class ShoppingBagScreen(val route: String) {
    object ShoppingBag : ShoppingBagScreen("client/shopping_bag")
    object AddressList: ShoppingBagScreen("client/address/list")
    object AddressCreate: ShoppingBagScreen("client/address/create")



}