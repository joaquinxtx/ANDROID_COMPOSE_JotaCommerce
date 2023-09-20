package com.joaquindev.jotacommerce.presentation.screens.admin.product.update


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.components.UpdateProduct


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminProductUpdateScreen(navController: NavHostController , productParam:String){
    
    Scaffold(
        topBar = {
            TopBar(navController = navController ,  arrowBack = true , iconTint = Color.White)

        }
    ) {
        AdminProductUpdateContent(paddingValues = it)
    }
    UpdateProduct()
    
}