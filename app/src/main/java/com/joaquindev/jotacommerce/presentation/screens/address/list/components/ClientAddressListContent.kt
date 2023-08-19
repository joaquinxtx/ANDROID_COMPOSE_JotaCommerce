package com.joaquindev.jotacommerce.presentation.screens.address.list.components

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue


@Composable
fun ClientAddressListContent(paddingValues: PaddingValues, addressList: List<Address> , navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Cafe_blue,
                modifier = Modifier
                    .size(34.dp)
            )
        }
        LazyColumn() {
            items(
                items = addressList
            ) {
                ClientAddressListItem(address = it)
            }
        }
    }
}