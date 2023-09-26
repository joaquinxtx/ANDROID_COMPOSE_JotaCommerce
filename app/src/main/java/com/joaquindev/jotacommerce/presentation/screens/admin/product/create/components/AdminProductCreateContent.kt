package com.joaquindev.jotacommerce.presentation.screens.admin.product.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.components.DialogCapturePicture

import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.AdminProductCreateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@Composable
fun AdminProductCreateContent(
    paddingValues: PaddingValues,
    vm: AdminProductCreateViewModel = hiltViewModel(),
) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember {
        mutableStateOf(false)
    }
    val stateDialogImageNumber = remember {
        mutableStateOf(1)
    }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto(stateDialogImageNumber.value) },
        pickImage = { vm.pickImage(stateDialogImageNumber.value) })
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            if (state.image1 != "") {
                AsyncImage(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .clickable {
                            stateDialogImageNumber.value = 1
                            stateDialog.value = true
                        },
                    model = state.image1,
                    contentDescription = stringResource(id = R.string.image),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(120.dp)


                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 1
                        },
                    painter = painterResource(id = R.drawable.subir),
                    contentDescription = stringResource(id = R.string.upload_image),
                    contentScale = ContentScale.Crop


                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            if (state.image2 != "") {
                AsyncImage(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)

                        .clickable {
                            stateDialogImageNumber.value = 2
                            stateDialog.value = true
                        },
                    model = state.image2,
                    contentDescription = stringResource(id = R.string.image),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(120.dp)


                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 2
                        },
                    painter = painterResource(id = R.drawable.subir),
                    contentDescription = stringResource(id = R.string.upload_image),
                    contentScale = ContentScale.Crop


                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Card(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ), colors = CardDefaults.cardColors(Cafe_white),
            elevation = CardDefaults.cardElevation(18.dp)
        ) {
            Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)) {
                Text(
                    text = stringResource(id = R.string.create_product),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Cafe_blue,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                DefaultTextField(
                    modifier = Modifier,
                    value = state.name,
                    onValueChange = {
                        vm.onNameInput(it)
                    },
                    label = stringResource(id = R.string.product_name),
                    icon = Icons.Default.List,

                    )
                DefaultTextField(
                    modifier = Modifier,
                    value = state.description,
                    onValueChange = {
                        vm.onDescriptionInput(it)
                    },
                    label = stringResource(id = R.string.description),
                    icon = Icons.Default.Info,


                    )
                DefaultTextField(
                    modifier = Modifier,
                    value = state.price.toString(),
                    onValueChange = {
                        vm.onPriceInput(it)
                    },
                    label = stringResource(id = R.string.price),
                    icon = Icons.Default.Info,
                    keyboardType = KeyboardType.Number


                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultButton(modifier = Modifier
                    .fillMaxWidth(), text = stringResource(id = R.string.create_product),
                    onClick = {
                        vm.createProduct()
                    })

            }
        }
    }
}