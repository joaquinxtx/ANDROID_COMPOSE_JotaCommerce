package com.joaquindev.jotacommerce.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.MainActivity
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel

@Composable
fun ProfileIcon(vm: ProfileViewModel) {
    val activity: Activity? = LocalContext.current as? Activity

    Column(Modifier.fillMaxWidth()) {

        IconButton(modifier = Modifier.align(Alignment.End), onClick = {
            vm.logout()
            activity?.finish()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "",
                tint = Color.White
            )

        }
        IconButton(modifier = Modifier.align(Alignment.End), onClick = {
            activity?.finish()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Default.Close,
                contentDescription = "",
                tint = Color.White
            )

        }
        if (!vm.user?.image.isNullOrBlank()) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                model = vm.user?.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.camara),
                contentDescription = "",

                )

        }


    }
}