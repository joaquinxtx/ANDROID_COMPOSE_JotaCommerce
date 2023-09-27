package com.joaquindev.jotacommerce.presentation.screens.roles.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.domain.model.Rol
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun RolesItems(rol: Rol , navController: NavHostController){
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(30.dp))
        AsyncImage(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp).align(CenterHorizontally).clickable {
                    Log.d("RolesItem", "Ruta: ${rol.route}")
                    navController.navigate(route = rol.route) {
                        popUpTo(route = Graph.ROLES) { inclusive = true }
                    }
                },
            model = rol.image,
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = rol.name.uppercase(),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            modifier = Modifier
                .fillMaxWidth()
                ,
            textAlign = TextAlign.Center,
            color = Cafe_white
        )
    }
}