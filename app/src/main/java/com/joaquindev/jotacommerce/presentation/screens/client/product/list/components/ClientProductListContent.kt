package com.joaquindev.jotacommerce.presentation.screens.client.product.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components.AdminProductListItem
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue

@Composable
fun ClientProductListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    products: List<Product>
) {
    Column( modifier = Modifier.padding(paddingValues)){
        Card(
            modifier = Modifier

                .fillMaxSize()
                .background(Cafe_blue).padding(top = 10.dp)
                ,
            shape = RoundedCornerShape(
                topEnd = 30.dp,
                topStart = 30.dp
            )
        ) {
            Column(Modifier.fillMaxWidth()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(PaddingValues())
                        .fillMaxSize()
                ) {
                    items(items = products) {
                        ClientProductLisItem(navController = navController, product = it)
                    }
                }
            }

        }
    }

}