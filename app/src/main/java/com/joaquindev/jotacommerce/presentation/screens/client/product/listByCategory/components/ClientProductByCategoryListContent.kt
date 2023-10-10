package com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Product


@Composable
fun ClientProductByCategoryListContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    products: List<Product>
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(PaddingValues())
                .fillMaxSize()
        ) {
            items(items = products) {
                ClientProductByCategoryListItem(navController = navController, product = it)
            }
        }
    }
}

