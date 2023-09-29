package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue

@Composable
fun ClientShoppingBagContent(
    paddingValues: PaddingValues,
    shoppingBag: MutableList<ShoppingBagProduct>,

) {
        Column {
            Card( modifier = Modifier

                .fillMaxSize()
                .background(Cafe_blue)
                .padding(top = 10.dp),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                )
            ) {
                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    items(items = shoppingBag) {
                        ClientShoppingBagItem(shoppingBagProduct = it)
                    }
                }

            }
        }


    }
