package com.joaquindev.jotacommerce.presentation.screens.client.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.components.TopBar

@Composable
fun ClientCategoryListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    categories: List<Category>
) {
    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fondoproductos),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(
                    0.6f,
                    0.6f,
                    0.6f,
                    1f
                )

            })
        )
        Column() {
            TopBar(navController = navController , title = "Categorias")
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(start = 20.dp, end = 20.dp, bottom = 55.dp)
            ) {
                items(
                    items = categories
                ) {
                    ClientCategoryListItem(navController = navController, category = it)
                }
            }
        }
}
}