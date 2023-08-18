package com.joaquindev.jotacommerce.presentation.screens.address.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ClientAddressListContent(paddingValues: PaddingValues){
    Text(text = "ClientAddressListScreen" , modifier = Modifier.padding(paddingValues) )
}