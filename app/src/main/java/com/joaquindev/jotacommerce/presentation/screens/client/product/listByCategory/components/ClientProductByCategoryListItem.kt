package com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListViewModel
import com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.ClientProductByCategoryListViewModel

@Composable
fun ClientProductByCategoryListItem(
    navController: NavHostController,
    product: Product,
    vm: ClientProductByCategoryListViewModel = hiltViewModel()
) {
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)

    ) {

        Row() {


            AsyncImage(
                model = product.image1, contentDescription = "", modifier = Modifier
                    .size(70.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = product.name, fontSize = 17.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = product.description, fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = product.price.toString(), fontSize = 17.sp)
            }
            Spacer(modifier = Modifier.width(15.dp))


        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.LightGray, startIndent = 30.dp)
    }
}
