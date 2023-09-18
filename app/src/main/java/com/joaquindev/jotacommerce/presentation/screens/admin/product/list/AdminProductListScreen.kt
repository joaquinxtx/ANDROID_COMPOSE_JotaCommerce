package com.joaquindev.jotacommerce.presentation.screens.admin.product.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components.DeleteProduct
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components.GetProducts
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminProductListScreen(navController: NavHostController, categoryParam: String , vm:AdminProductListViewModel = hiltViewModel()) {
    val categoryParse = Category.fromJson(categoryParam).toJson()
    Scaffold(
        topBar = { TopBar(arrowBack = true, navController = navController , photoUrl = vm.user?.image, profilePhoto = true , )},

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        route = AdminCategoryScreen.ProductCreate.passCategory(categoryParse)
                    )
                },
                modifier = Modifier.padding(bottom = 10.dp),
                containerColor = Cafe_orange,
                contentColor = Cafe_white

            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        GetProducts(navController = navController, paddingValues = it)
        DeleteProduct()
    }
}