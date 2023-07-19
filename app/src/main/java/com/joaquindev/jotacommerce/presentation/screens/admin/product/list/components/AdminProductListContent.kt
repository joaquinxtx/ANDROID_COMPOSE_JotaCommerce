package com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun AdminProductListContent(
    navController:NavHostController,
    paddingValues: PaddingValues,
    products:List<Product>
) {
   LazyColumn(modifier = Modifier.padding(PaddingValues()).fillMaxSize()){
       items(items = products){
           AdminProductListItem(navController =navController , product = it)
       }
   }
}