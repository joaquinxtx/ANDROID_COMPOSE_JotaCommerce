package com.joaquindev.jotacommerce.presentation.screens.roles.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R

import com.joaquindev.jotacommerce.presentation.screens.roles.RolesViewModel

@Composable
fun RolesContent(
    paddingValues: PaddingValues,
    vm: RolesViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val data = vm.authResponse.user
    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fondocofferol),
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
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            items(
                items = data?.roles ?: arrayListOf()
            ) { rol ->
                RolesItems(rol = rol, navController = navController)
            }
        }

    }

}
