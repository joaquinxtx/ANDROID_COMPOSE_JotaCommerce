package com.joaquindev.jotacommerce.presentation.screens.address.list


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen

import com.joaquindev.jotacommerce.presentation.screens.address.create.components.ClientAddressCreateContent
import com.joaquindev.jotacommerce.presentation.screens.address.list.components.ClientAddressListContent
import com.joaquindev.jotacommerce.presentation.screens.address.list.components.GetAddress
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientAddressListScreen(
    navController: NavHostController,
    vm: ClientAddressListViewModel = hiltViewModel()
) {

    vm.getSessionData()
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate(route = ShoppingBagScreen.AddressCreate.route) },
            modifier = Modifier.padding(bottom = 20.dp),
            containerColor = Cafe_orange,
            contentColor = Cafe_white

        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.padding(20.dp),
                text = "Continuar",
                onClick = { navController.navigate(route = ShoppingBagScreen.PaymentsForm.route) })
        }) {
        GetAddress(paddingValues = it, navController = navController)
    }
}