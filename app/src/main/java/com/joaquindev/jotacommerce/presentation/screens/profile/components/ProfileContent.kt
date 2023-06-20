package com.joaquindev.jotacommerce.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.MainActivity
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(paddingValues: PaddingValues, vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    DefaultButton(
        modifier = Modifier.padding(paddingValues),
        text = "Cerrar sesion",
        onClick = {
            vm.logout()
            activity?.finish()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
        })
}