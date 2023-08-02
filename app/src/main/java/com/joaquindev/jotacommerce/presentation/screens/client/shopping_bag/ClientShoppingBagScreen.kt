package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(navController: NavHostController) {
    Scaffold() {
        ClientShoppingBagContent(paddingValues = it)

    }
}