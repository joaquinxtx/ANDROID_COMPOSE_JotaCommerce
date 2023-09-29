package com.joaquindev.jotacommerce.presentation.screens.client.product.list


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBarClient
import com.joaquindev.jotacommerce.presentation.screens.client.product.list.components.GetProducts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductListScreen(navController: NavHostController) {
    Scaffold(topBar = { TopBarClient(navController = navController)}) {
        GetProducts(navController = navController, paddingValues = it)
    }
}