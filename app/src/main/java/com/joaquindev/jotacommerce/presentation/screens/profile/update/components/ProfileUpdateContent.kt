package com.joaquindev.jotacommerce.presentation.screens.profile.update.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import coil.compose.AsyncImage
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DialogCapturePicture
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@Composable
fun ProfileUpdateContent(
    paddingValues: PaddingValues,
    vm: ProfileUpdateViewModel = hiltViewModel(),

) {

    val state = vm.state

    val stateDialog = remember {
        mutableStateOf(false)
    }
    vm.resultingActivityHandler.handle()

    DialogCapturePicture(state = stateDialog, takePhoto = { vm.takePhoto() }, pickImage = {
        vm.pickImage()
    })
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {

        Card(   modifier = Modifier

            .fillMaxSize()
            .background(Cafe_blue)
            .padding(top = 10.dp)
            ,
            shape = RoundedCornerShape(
                topEnd = 30.dp,
                topStart = 30.dp)) {
            Column(Modifier.fillMaxWidth()) {


                if (state.image != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(150.dp).padding(top = 20.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                            .clickable { stateDialog.value = true },
                        model = state.image,
                        contentDescription = stringResource(id = R.string.image),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        modifier = Modifier.padding(top = 20.dp)
                            .size(150.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                            .clickable { stateDialog.value = true },
                        painter = painterResource(id = R.drawable.perfil),
                        contentDescription = "",

                        )
                }
                Text(
                    modifier = Modifier
                        .padding(vertical = 25.dp)
                        .align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.confirm),
                    color = Cafe_white,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(0.3f))
            ProfileUpdateUserData(vm = vm, state = state)
        }

    }

}