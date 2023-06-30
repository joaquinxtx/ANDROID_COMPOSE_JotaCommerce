package com.joaquindev.jotacommerce.presentation.screens.admin.category.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun AdminCategoryCreateContent(paddingValues: PaddingValues, navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            ,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Cafe_blue,
                modifier = Modifier
                    .size(34.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.subir),
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )

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
                    text = "Nueva Categoria",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Cafe_blue,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                DefaultTextField(
                    modifier = Modifier,
                    value = "",
                    onValueChange = {

                    },
                    label = "Nombre de la categoria",
                    icon = Icons.Default.List,

                    )
                DefaultTextField(
                    modifier = Modifier,
                    value = "",
                    onValueChange = {

                    },
                    label = "Descripcion",
                    icon = Icons.Default.Info,

                    hideText = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultButton(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), text = "CREAR CATEGORIA", onClick = {

                })

            }
        }
    }
}
