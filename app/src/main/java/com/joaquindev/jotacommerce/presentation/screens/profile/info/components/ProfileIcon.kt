package com.joaquindev.jotacommerce.presentation.screens.profile.info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileViewModel

@Composable
fun ProfileIcon(vm: ProfileViewModel) {
    Column(Modifier.fillMaxWidth().padding(top = 50.dp)) {
        if (!vm.user?.image.isNullOrBlank()) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                model = vm.user?.image,
                contentDescription = stringResource(id = R.string.image),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = stringResource(id = R.string.upload_image),

                )
        }
    }
}