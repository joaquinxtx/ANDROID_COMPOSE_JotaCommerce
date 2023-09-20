package com.joaquindev.jotacommerce.presentation.screens.admin.product.create

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.components.CreateProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminProductCreateScreen(navController: NavHostController , categoryParam:String){
    
    Scaffold(topBar = { TopBar(navController = navController ,  arrowBack = true ) }) {
        AdminProductCreateContent(paddingValues = it)
    }

    CreateProduct()
    
}