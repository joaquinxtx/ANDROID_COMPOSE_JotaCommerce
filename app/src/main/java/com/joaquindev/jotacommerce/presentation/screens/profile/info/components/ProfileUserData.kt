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
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ProfileUserData(vm : ProfileViewModel, navController:NavHostController){
    Card(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp
        ),
        colors = CardDefaults.cardColors(Cafe_white.copy(alpha = 0.8f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Cafe_orange,
                    modifier = Modifier.padding(end = 10.dp).size(20.dp)
                )
                Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text(text = "${vm.user?.name} ${vm.user?.lastname}", fontWeight = FontWeight.Medium)
                    Text(
                        text = "Nombre de Usuario",
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
                    tint = Cafe_orange,
                    modifier = Modifier.padding(end = 10.dp).size(20.dp)
                )
                Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text(text = vm.user?.email.toString(), fontWeight = FontWeight.Medium)
                    Text(
                        text = "email",
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
                    imageVector = Icons.Default.Phone,
                    contentDescription = "",
                    tint = Cafe_orange,
                    modifier = Modifier.size(29.dp)
                )
                Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text(text = vm.user?.phone.toString() , fontWeight = FontWeight.Medium)
                    Text(
                        text = "Phone",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                }

            }
            Spacer(modifier = Modifier.height(30.dp))
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Actualizar informacion",
                onClick = { navController.navigate(route= "${Graph.PROFILE}/${vm.user?.toJson()}") })
        }
    }
}