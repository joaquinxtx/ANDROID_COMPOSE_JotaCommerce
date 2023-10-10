package com.joaquindev.jotacommerce.presentation.screens.client.category.list.components


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientCategoryScreen


@Composable
fun ClientCategoryListItem(navController: NavHostController, category: Category) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                Log.d("client", category.toJson())
                val bundle = bundleOf(
                    "categoryJson" to category.toJson(),
                    "categoryName" to category.name
                )
                navController.navigate(
                    route = ClientCategoryScreen.ProductList.passCategory(
                        bundle.toString()
                    )
                )
            },
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(Modifier) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .height(130.dp),
                model = category.image,
                contentDescription = stringResource(id = R.string.image),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(
                    ColorMatrix().apply {
                        setToScale(0.5f, 0.5f, 0.5f, 1f)
                    }
                ))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(10.dp), text = category.name,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 34.sp
                )
            }
        }
    }
}