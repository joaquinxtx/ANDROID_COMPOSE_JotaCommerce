package com.joaquindev.jotacommerce.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.address.create.ClientAddressCreateScreen

import com.joaquindev.jotacommerce.presentation.screens.address.list.ClientAddressListScreen

import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.ClientShoppingBagScreen

fun NavGraphBuilder.ShoppingBagNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ) {

        composable(
            route = ShoppingBagScreen.ShoppingBag.route

        ) {
         ClientShoppingBagScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressList.route

        ) {
         ClientAddressListScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressCreate.route

        ) {
         ClientAddressCreateScreen(navController = navController)
        }


    }
}
