package com.joaquindev.jotacommerce.presentation.components

import android.app.Activity
import android.content.Intent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.MainActivity
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminMenu
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@Composable
fun TopBar(
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
                        contentDescription = stringResource(id = R.string.icon_menu),
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
                        contentDescription = stringResource(id = R.string.shopping_cart),
                        tint = iconTint,
                        modifier = Modifier.size(34.dp)
                    )
                }
            }
        }
        AnimatedDropdownMenu(
            isMenuOpen = isMenuOpen,
            navController = navController,
            onDismissRequest = { isMenuOpen = false })
    }
}


@Composable
fun BackButton(navController: NavHostController, iconTint: Color) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.icon_arrow_back),
            tint = iconTint,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
fun TitleText(title: String?, titleColor: Color) {
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
fun ShoppingCartButton(navController: NavHostController, iconTint: Color) {
    IconButton(
        onClick = { navController.navigate(route = ShoppingBagScreen.ShoppingBag.route) }
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = stringResource(id = R.string.shopping_cart),
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
                .clip(CircleShape),
            model = photoUrl,
            contentDescription = stringResource(id = R.string.image),
            contentScale = ContentScale.Crop
        )
    } else {

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = stringResource(id = R.string.icon_user),
            modifier = modifier
        )
    }
}

@Composable
fun CustomDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) {
    if (expanded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onDismissRequest)
        ) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight(),
                shadowElevation = 16.dp,
                shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                content = content
            )
        }
    }
}

@Composable
fun AnimatedDropdownMenu(
    isMenuOpen: Boolean,
    onDismissRequest: () -> Unit,
    navController: NavHostController,
    vm: ProfileViewModel = hiltViewModel()
) {
    val activity: Activity? = LocalContext.current as? Activity
    val navigationMenu = listOf(
        AdminMenu.Profile,
        AdminMenu.CategoryList,
        AdminMenu.CreateCategory
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = navigationMenu.any { it.route == currentDestination?.route }
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
                    contentDescription = stringResource(id = R.string.image),
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.height(20.dp))
                if (bottomBarDestination) {
                    navigationMenu.forEach {
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
                                Icon(imageVector = it.icon, contentDescription = stringResource(id = R.string.icon))
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
                            contentDescription = stringResource(id = R.string.icon_clear),
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = stringResource(id = R.string.change_role), modifier = Modifier.fillMaxWidth())
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(6.dp)
                            .clickable {
                                vm.logout()
                                activity?.finish()
                                activity?.startActivity(Intent(activity, MainActivity::class.java))
                            }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = stringResource(id = R.string.icon_clear),
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = stringResource(id = R.string.sign_off), modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}


