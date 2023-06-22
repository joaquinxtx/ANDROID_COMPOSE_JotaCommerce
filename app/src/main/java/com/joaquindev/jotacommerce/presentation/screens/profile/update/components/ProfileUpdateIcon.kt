package com.joaquindev.jotacommerce.presentation.screens.profile.update.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ProfileUpdateIcon(
    vm: ProfileUpdateViewModel,
    navController: NavHostController,
    modifier: Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        IconButton(onClick = { navController.popBackStack() }, modifier = modifier) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Cafe_white,
                modifier = modifier
                    .size(34.dp)
            )
        }

        if (!vm.user?.image.isNullOrBlank()) {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                model = vm.user?.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.camara),
                contentDescription = "",

                )
        }
        Text(
            modifier = Modifier.padding(bottom = 15.dp).align(Alignment.CenterHorizontally),
            text = "Actualizar Perfil",
            color = Cafe_white,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}