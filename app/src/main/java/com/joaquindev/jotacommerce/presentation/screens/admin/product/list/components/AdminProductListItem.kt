package com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete

import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.FractionalThreshold
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


//Arreglar el texfiel del precio
//pasar todo al view model
//Iconos de interner

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AdminProductListItem(
    navController: NavHostController,
    product: Product,
    vm: AdminProductListViewModel = hiltViewModel()
) {
    val dismissState = rememberDismissState()
    val dismissDirection = dismissState.dismissDirection
    val isDismissed = dismissState.isDismissed(DismissDirection.EndToStart)

    if (isDismissed && dismissDirection == DismissDirection.EndToStart) {
        val scope = rememberCoroutineScope()
        scope.launch {
            delay(300)
            vm.deleteProduct(product.id ?: "")
        }
    }

    val degrees by animateFloatAsState(
        if (dismissState.targetValue == DismissValue.Default) 0f else -45f
    )
    var itemAppeared by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        itemAppeared = true
    }
    AnimatedVisibility(
        visible = itemAppeared && !isDismissed,
        enter = expandVertically(
            animationSpec = tween(
                durationMillis = 300
            )
        ),
        exit = shrinkVertically(
            animationSpec = tween(
                durationMillis = 300
            )
        )
    ) {
        SwipeToDismiss(
            state = dismissState,
            directions = setOf(DismissDirection.EndToStart),
            dismissThresholds = { FractionalThreshold(fraction = 0.2f) },
            background = { RedBackground(degrees = degrees) },
            dismissContent = {
                Card(

                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(20.dp)
                        .height(90.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Row() {
                        AsyncImage(
                            model = product.image1, contentDescription = "", modifier = Modifier
                                .size(90.dp)
                               ,
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = product.name,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(text = product.description, fontSize = 14.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "$${product.price}",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                        }

                        IconButton(onClick = {
                            navController.navigate(
                                route = AdminCategoryScreen.ProductUpdate.passProduct(
                                    product.toJson()
                                )
                            )
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "",
                                tint = Color.Green
                            )

                        }
                    }
                }
            }
        )
    }

}

@Composable
fun RedBackground(degrees: Float) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(23.dp)
            .height(87.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Red),

    ) {
        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)) {
            Icon(
                modifier = Modifier.rotate(degrees = degrees),
                imageVector = Icons.Filled.Delete,
                contentDescription = "",
                tint = Color.White
            )

        }
    }
}
