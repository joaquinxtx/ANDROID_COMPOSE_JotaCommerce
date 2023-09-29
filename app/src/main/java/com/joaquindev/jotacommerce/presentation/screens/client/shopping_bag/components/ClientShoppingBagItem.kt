package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue

@Composable
fun ClientShoppingBagItem(
    shoppingBagProduct: ShoppingBagProduct,
    vm: ClientShoppingBagViewModel = hiltViewModel()
) {
    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = shoppingBagProduct.image1,
            contentDescription = stringResource(id = R.string.image)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = shoppingBagProduct.name,
                modifier = Modifier.width(150.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(containerColor = Cafe_blue),
                modifier = Modifier
                    .width(100.dp)
                    .height(35.dp)
            ) {
                Row(

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "-", fontSize = 18.sp,

                        color = Color.White,
                        modifier = Modifier.clickable { vm.subtractItem(shoppingBagProduct) }
                    )
                    Text(
                        text = shoppingBagProduct.quantity.toString(), fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "+", fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.clickable { vm.addItem(shoppingBagProduct) }
                    )
                }
            }

        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = (shoppingBagProduct.price * shoppingBagProduct.quantity).toString())
            Spacer(modifier = Modifier.height(5.dp))
            IconButton(
                onClick = { vm.removeItem(shoppingBagProduct.id) },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(id = R.string.icon_delete),
                    modifier = Modifier.size(30.dp)
                )

            }
        }

    }

}