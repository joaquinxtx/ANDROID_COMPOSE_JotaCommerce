package com.joaquindev.jotacommerce.presentation.screens.profile.info.components

import android.app.Activity

import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel


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
            Spacer(modifier = Modifier.weight(0.5f))
            ProfileUserData(vm = vm , navController = navController )
        }

    }

}