package com.joaquindev.jotacommerce.presentation.components



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen


@Composable
fun TopBar(
    navController: NavHostController,
    arrowBack: Boolean = false,
    title: String? = null,
    photoUrl: String? = null,
    profilePhoto:Boolean = false,
    showCart: Boolean = false,
    iconTint: Color = Color.Black,
    titleColor: Color = Color.Black
) {
    Surface(
        color = Color.White,
        tonalElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (arrowBack) {
                BackButton(navController,iconTint)
            }else {
                MenuItemButton(iconTint)
            }
            Spacer(modifier = Modifier.weight(1f))
            TitleText(title, titleColor)
            Spacer(modifier = Modifier.weight(1f))
            if (showCart) {
                ShoppingCartButton(navController,iconTint)
            } else if (profilePhoto) {
                ProfilePhoto(photoUrl = photoUrl )
            } else {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Shopping Cart",
                        tint = iconTint,
                        modifier = Modifier.size(34.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun BackButton(navController: NavHostController , iconTint: Color) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = iconTint,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
private fun MenuItemButton(iconTint: Color) {
    IconButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "",
            tint = iconTint,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
private fun TitleText(title: String?, titleColor: Color) {
    Text(
        text = title.orEmpty(),
        modifier = Modifier

            .padding(horizontal = 16.dp),
        color = titleColor,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ShoppingCartButton(navController: NavHostController,iconTint: Color) {
    IconButton(
        onClick = { navController.navigate(route = ShoppingBagScreen.ShoppingBag.route) }
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Shopping Cart",
            tint = iconTint,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
fun ProfilePhoto(photoUrl: String?, modifier: Modifier = Modifier) {

    if (!photoUrl.isNullOrBlank()) {

        AsyncImage(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                ,
            model = photoUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    } else {

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Icono de usuario",
            modifier = modifier
        )
    }
}