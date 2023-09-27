package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBarClient
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(
    navController: NavHostController,
    vm: ClientShoppingBagViewModel = hiltViewModel()
) {

    vm.getShoppingBag()
    Scaffold(
        topBar = { TopBarClient(navController = navController ,  arrowBack = true) },
        bottomBar = {
            ClientShoppingBagBottomBar(navController = navController)
        }

    ) {
        ClientShoppingBagContent(paddingValues = it, vm.shoppingBag )

    }
}