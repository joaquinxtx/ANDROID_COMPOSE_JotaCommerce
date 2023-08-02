package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ClientShoppingBagContent(paddingValues: PaddingValues){
    Text(text = "Client shopping bag", modifier = Modifier.padding(paddingValues))

}