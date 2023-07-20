package com.joaquindev.jotacommerce.presentation.screens.admin.product.update

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.components.CreateProduct
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.components.UpdateProduct
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminProductUpdateScreen(navController: NavHostController , productParam:String){
    
    Scaffold(
    ) {
        AdminProductUpdateContent(paddingValues = it, navController=navController)
    }
    UpdateProduct()
    
}