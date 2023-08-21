package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct

@Composable
fun ClientShoppingBagContent(paddingValues: PaddingValues, shoppingBag: MutableList<ShoppingBagProduct>) {
    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fondoproductos),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(
                    0.4f,
                    0.4f,
                    0.4f,
                    1f
                )

            })
        )

    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(items = shoppingBag) {
            ClientShoppingBagItem(shoppingBagProduct = it)
        }
    }

}}