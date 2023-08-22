package com.joaquindev.jotacommerce.presentation.screens.client.product.detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.client.product.detail.components.ClientProductDetailContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductDetailScreen(navController: NavHostController , productParam:String){

    
    Scaffold() {
       ClientProductDetailContent(paddingValues = it , navController =navController )
    }
    
}