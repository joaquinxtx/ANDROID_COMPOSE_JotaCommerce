package com.joaquindev.jotacommerce.presentation.screens.admin.category.update.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.components.DialogCapturePicture
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.AdminCategoryUpdateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun AdminCategoryUpdateContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: AdminCategoryUpdateViewModel = hiltViewModel()
) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember {
        mutableStateOf(false)
    }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() })
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Cafe_blue,
                modifier = Modifier
                    .size(34.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        if (state.image != "") {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                model = state.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                painter = painterResource(id = R.drawable.subir),
                contentDescription = "",
                contentScale = ContentScale.Crop


                )
        }

        Spacer(modifier = Modifier.weight(1f))
        Card(
            modifier = Modifier
                .height(320.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ), colors = CardDefaults.cardColors(Cafe_white),
            elevation = CardDefaults.cardElevation(18.dp)
        ) {
            Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)) {
                Text(
                    text = "Actualizar Categoria",
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
                    label = "Nombre de la categoria",
                    icon = Icons.Default.List,

                    )
                DefaultTextField(
                    modifier = Modifier,
                    value = state.description,
                    onValueChange = {
                        vm.onDescriptionInput(it)
                    },
                    label = "Descripcion",
                    icon = Icons.Default.Info,


                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultButton(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), text = "CREAR CATEGORIA",
                    onClick = {
                    vm.createCategory()
                })

            }
        }
    }
}
