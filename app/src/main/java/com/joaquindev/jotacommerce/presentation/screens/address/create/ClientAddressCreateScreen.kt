package com.joaquindev.jotacommerce.presentation.screens.address.create

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.address.create.components.ClientAddressCreateContent
import com.joaquindev.jotacommerce.presentation.screens.address.create.components.CreateAddress
import com.joaquindev.jotacommerce.presentation.screens.address.list.components.ClientAddressListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientAddressCreateScreen(
    navController: NavHostController,
    vm: ClientAddressCreateViewModel = hiltViewModel()
) {
    vm.getSessionData()
    Scaffold() {
        ClientAddressCreateContent(paddingValues = it)
    }
    CreateAddress()
}