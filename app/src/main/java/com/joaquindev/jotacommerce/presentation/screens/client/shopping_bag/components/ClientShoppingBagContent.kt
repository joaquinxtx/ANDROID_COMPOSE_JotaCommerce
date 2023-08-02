package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct

@Composable
fun ClientShoppingBagContent(paddingValues: PaddingValues, shoppingBag: MutableList<ShoppingBagProduct>) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(items = shoppingBag) {
            ClientShoppingBagItem(shoppingBagProduct = it)
        }
    }

}