package com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun AdminProductListContent(
    navController:NavHostController,
    paddingValues: PaddingValues,
    products:List<Product>
) {
    Column(Modifier.fillMaxWidth()) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Cafe_blue,
                modifier = Modifier
                    .size(34.dp)
            )
        }
        LazyColumn(
            modifier = Modifier
                .padding(PaddingValues())
                .fillMaxSize()
        ) {
            items(items = products) {
                AdminProductListItem(navController = navController, product = it)
            }
        }
    }
}