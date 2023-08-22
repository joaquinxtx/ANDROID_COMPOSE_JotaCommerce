package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(
    navController: NavHostController,
    vm: ClientShoppingBagViewModel = hiltViewModel()
) {

    vm.getShoppingBag()
    Scaffold(
        bottomBar = {
            ClientShoppingBagBottomBar(navController = navController)
        }

    ) {
        ClientShoppingBagContent(paddingValues = it, vm.shoppingBag , navController)

    }
}