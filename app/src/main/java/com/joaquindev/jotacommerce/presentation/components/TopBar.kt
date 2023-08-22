package com.joaquindev.jotacommerce.presentation.components

import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun TopBar(
    navController: NavHostController,
    arrowBack:Boolean= false,
    title: String? = null,
    showCart: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (arrowBack) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Cafe_white,
                modifier = Modifier
                    .size(34.dp)
            )
        }
        }

        Text(
            text = title.orEmpty(),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            color=Color.White ,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp
            ),
            textAlign = TextAlign.Center
        )

        if (showCart) {
            IconButton(
                onClick = { navController.navigate(route = ShoppingBagScreen.ShoppingBag.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Shopping Cart",
                    tint = Color.White,
                    modifier = Modifier
                        .size(34.dp)
                )
            }
        }else{
            Box(modifier = Modifier.size(34.dp))
        }
    }
}