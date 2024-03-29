package com.joaquindev.jotacommerce.presentation.screens.address.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.address.create.ClientAddressCreateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ClientAddressCreateContent(
    paddingValues: PaddingValues,
    vm: ClientAddressCreateViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state = vm.state

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            navController = navController,
            arrowBack = true,
            titleColor = Cafe_white,
            iconTint = Cafe_white,
            title = stringResource(id = R.string.new_address)
        )
        Card(
            modifier = Modifier

                .fillMaxSize()
                .background(Cafe_blue)
                .padding(top = 10.dp),
            shape = RoundedCornerShape(
                topEnd = 30.dp,
                topStart = 30.dp
            )
        ) {

            Image(
                modifier = Modifier
                    .size(150.dp)

                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.subir),
                contentDescription = stringResource(id = R.string.upload_image),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ), colors = CardDefaults.cardColors(Cafe_white),
                elevation = CardDefaults.cardElevation(18.dp)
            ) {
                Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)) {
                    Text(
                        text = stringResource(id = R.string.location),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Cafe_blue,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    DefaultTextField(
                        modifier = Modifier,
                        value = state.address,
                        onValueChange = {
                            vm.onAddressInput(it)
                        },
                        label = stringResource(id = R.string.address),
                        icon = Icons.Default.LocationOn,
                        )
                    DefaultTextField(
                        modifier = Modifier,
                        value = state.neighborhood,
                        onValueChange = {
                            vm.onNeighborhoodInput(it)
                        },
                        label = stringResource(id = R.string.neighborhood),
                        icon = Icons.Default.Home,
                        )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp), text = stringResource(id = R.string.create_address),
                        onClick = {
                            vm.createAddress()
                        })

                }
            }
        }
    }

}