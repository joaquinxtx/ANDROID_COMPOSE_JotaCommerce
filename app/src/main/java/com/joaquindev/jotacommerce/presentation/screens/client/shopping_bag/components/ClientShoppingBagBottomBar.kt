package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel

@Composable
fun ClientShoppingBagBottomBar(vm: ClientShoppingBagViewModel = hiltViewModel() , navController:NavHostController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 15.dp)) {
            Text(text = "TOTAL", fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(text = vm.total.toString() + "$", fontSize = 17.sp)
        }

        DefaultButton(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "confirmar orden",
            onClick = { navController.navigate(route= ShoppingBagScreen.AddressList.route)})
    }
}