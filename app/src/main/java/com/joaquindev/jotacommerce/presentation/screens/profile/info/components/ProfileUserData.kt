package com.joaquindev.jotacommerce.presentation.screens.profile.info.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ProfileUserData(vm : ProfileViewModel, navController:NavHostController){
    Card(
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp , end = 10.dp),
        shape = RoundedCornerShape(
            topEnd = 40.dp,
            topStart = 40.dp
        ),
        colors = CardDefaults.cardColors(Cafe_white)
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp)
        ) {
            Text(
                text = "Perfil",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Cafe_blue,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Cafe_orange
                )
                Column() {
                    Text(text = "${vm.user?.name} ${vm.user?.lastname}" )
                    Text(
                        text = "Nombre de usuario",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = Cafe_orange
                )
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Text(text = vm.user?.email ?: "")
                    Text(
                        text = "Correo electronico",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "",
                    tint = Cafe_orange
                )
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Text(text = vm.user?.phone ?: "")
                    Text(
                        text = "Telefono",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Actualizar perfil",
                onClick = {navController.navigate(route= "${Graph.PROFILE}/${vm.user?.toJson()}") })

        }
    }
}