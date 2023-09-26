package com.joaquindev.jotacommerce.presentation.screens.admin.category.list.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.CafeGrayTransparent

@Composable
fun AdminCategoryListItem(
    navController: NavHostController,
    category: Category,
    vm: AdminCategoryListViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .clickable {
                navController.navigate(
                    route = AdminCategoryScreen.ProductList.passCategory(category.toJson())
                )
            },
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(Modifier) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .height(170.dp),
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
                Row {
                    Card(
                        modifier = Modifier.size(48.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(containerColor = CafeGrayTransparent)
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate(
                                    route = AdminCategoryScreen.CategoryUpdate.passCategory(
                                        category.toJson()
                                    )
                                )
                            }, modifier = Modifier.fillMaxSize()

                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = stringResource(id = R.string.icon_edit),
                                tint = Color.Green,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Card(
                        modifier = Modifier.size(48.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(containerColor = CafeGrayTransparent)
                    ) {
                        IconButton(
                            onClick = { vm.deleteCategory(category.id ?: "") },
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = stringResource(id = R.string.icon_delete),
                                tint = Color.Red,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                    }
                }
            }
        }
    }
}
