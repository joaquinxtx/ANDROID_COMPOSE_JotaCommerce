package com.joaquindev.jotacommerce.presentation.components

import android.app.Activity
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.MainActivity
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientMenu
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun TopBarClient(
    navController: NavHostController,
    arrowBack: Boolean = false,
    title: String? = null,
    photoUrl: String? = null,

    profilePhoto: Boolean = false,
    showCart: Boolean = false,
    iconTint: Color = Color.Black,
    titleColor: Color = Color.Black,
) {
    var isMenuOpen by remember { mutableStateOf(false) }
    Surface(
        color = Cafe_white.copy(alpha = 0f),
        tonalElevation = 4.dp,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (arrowBack) {
                BackButton(navController, iconTint)
            } else {
                IconButton(
                    onClick = { isMenuOpen = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                        tint = iconTint,
                        modifier = Modifier.size(34.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            TitleText(title, titleColor)
            Spacer(modifier = Modifier.weight(1f))
            if (showCart) {
                ShoppingCartButton(navController, iconTint)
            } else if (profilePhoto) {
                ProfilePhoto(photoUrl = photoUrl)
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
        AnimatedDropdownMenuClient(
            isMenuOpen = isMenuOpen,
            navController = navController,
            onDismissRequest = { isMenuOpen = false })
    }
}
@Composable
fun AnimatedDropdownMenuClient(
    isMenuOpen: Boolean,
    onDismissRequest: () -> Unit,
    navController: NavHostController,
) {
    val activity: Activity? = LocalContext.current as? Activity
    val navigationMenuClient = listOf(
        ClientMenu.Profile,
        ClientMenu.Categories,
        ClientMenu.Products,
        ClientMenu.ShoppingCart
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = navigationMenuClient.any { it.route == currentDestination?.route }
    AnimatedVisibility(
        visible = isMenuOpen,
        enter = expandHorizontally(
            animationSpec = tween(
                durationMillis = 300
            )
        ),
        exit = shrinkHorizontally(
            animationSpec = tween(durationMillis = 300)
        )
    ) {
        CustomDropdownMenu(
            expanded = isMenuOpen,
            onDismissRequest = { onDismissRequest() }
        ) {
            Column(modifier = Modifier.padding(bottom = 65.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.perfiluser),
                    contentDescription = "",
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.height(20.dp))
                if (bottomBarDestination) {
                    navigationMenuClient.forEach {
                        DropdownMenuItem(onClick = {
                            navController.navigate(route = it.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                            }
                        }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .padding(6.dp)
                            ) {
                                Icon(imageVector = it.icon, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = it.title, modifier = Modifier.fillMaxWidth())
                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(6.dp)
                            .clickable {
                                activity?.finish()
                                activity?.startActivity(
                                    Intent(
                                        activity,
                                        MainActivity::class.java
                                    )
                                )
                            }
                    ) {

                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Cambiar rol", modifier = Modifier.fillMaxWidth())
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(6.dp)
                            .clickable {
                                activity?.finish()
                                activity?.startActivity(
                                    Intent(
                                        activity,
                                        MainActivity::class.java
                                    )
                                )
                            }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Cerrar sesion", modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}