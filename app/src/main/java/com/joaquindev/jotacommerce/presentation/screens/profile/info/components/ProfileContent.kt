package com.joaquindev.jotacommerce.presentation.screens.profile.info.components

import android.app.Activity

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@Composable
fun ProfileContent(paddingValues: PaddingValues, vm: ProfileViewModel = hiltViewModel(), navController: NavHostController) {
    val activity: Activity? = LocalContext.current as? Activity


    Box(
        modifier = Modifier
            .padding(paddingValues)
            .padding(bottom = 85.dp)
    ) {
        BackgroundImageProfile()

        Column {
            ProfileIcon(vm = vm, activity = activity)
            Text(
                modifier = Modifier
                    .padding(vertical = 25.dp)
                    .align(Alignment.CenterHorizontally),
                text = "${vm.user?.name?.uppercase()} ",
                color = Cafe_white,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(0.5f))
            ProfileUserData(vm = vm , navController = navController )
        }

    }

}