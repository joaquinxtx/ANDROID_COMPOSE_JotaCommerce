package com.joaquindev.jotacommerce.presentation.screens.roles.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.joaquindev.jotacommerce.presentation.screens.roles.RolesViewModel

@Composable
fun RolesContent(paddingValues: PaddingValues, vm: RolesViewModel = hiltViewModel() , navController: NavHostController) {

    val data = vm.authResponse.user
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = data?.roles ?: arrayListOf()

        ) {
            RolesItems(rol = it , navController =navController )
        }

    }

}