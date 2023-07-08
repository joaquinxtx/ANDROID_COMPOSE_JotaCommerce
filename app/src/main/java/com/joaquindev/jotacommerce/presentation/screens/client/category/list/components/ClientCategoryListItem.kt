package com.joaquindev.jotacommerce.presentation.screens.client.category.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.domain.model.Category

@Composable
fun ClientCategoryListItem(navController: NavHostController, category: Category) {
    Card(
        modifier = Modifier.padding(bottom = 15.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = category.image,
                contentDescription = "",

            )
            Text(
                modifier = Modifier.padding(10.dp), text = category.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(5.dp), text = category.description, fontSize = 14.sp

            )

        }
    }
}