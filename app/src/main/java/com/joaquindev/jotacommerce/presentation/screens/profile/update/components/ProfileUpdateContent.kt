package com.joaquindev.jotacommerce.presentation.screens.profile.update.components

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateViewModel


@Composable
fun ProfileUpdateContent(paddingValues: PaddingValues, vm : ProfileUpdateViewModel = hiltViewModel(), navController: NavHostController) {
    val activity: Activity? = LocalContext.current as? Activity

    Box(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        BackgroundImageUpdateProfile()

        Column {
            ProfileUpdateIcon(vm = vm, navController = navController, modifier = Modifier )
            Spacer(modifier = Modifier.weight(0.5f))
            ProfileUpdateUserData(vm = vm )
        }

    }

}