package com.joaquindev.jotacommerce.presentation.screens.profile.info.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@Composable
fun ProfileContent( vm: ProfileViewModel = hiltViewModel(), navController: NavHostController) {

    Box(
        modifier = Modifier

            .padding(bottom = 85.dp)
    ) {
        BackgroundImageProfile()

        Column {
            Column(Modifier.fillMaxWidth()) {
                ProfileIcon(vm = vm)
                Text(
                    modifier = Modifier
                        .padding(vertical = 25.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "${vm.user?.name?.uppercase()} ",
                    color = Cafe_white,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
                Spacer(modifier = Modifier.weight(1f))
                ProfileUserData(vm = vm, navController = navController)

        }
    }
}