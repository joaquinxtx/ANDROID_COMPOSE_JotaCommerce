package com.joaquindev.jotacommerce.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.MainActivity
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.screens.profile.ProfileViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange

import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ProfileContent(paddingValues: PaddingValues, vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity

    Box(modifier = Modifier
        .padding(paddingValues)
        .padding(bottom = 85.dp)) {
        Image(
            painter = painterResource(id = R.drawable.coffe3),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )

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
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.camara),
                contentDescription = "",

                )
            Spacer(modifier = Modifier.weight(1f))

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
                            Text(text = "PEPE ARGENTO")
                            Text(
                                text = "nombre de usuariio",
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
                            Text(text = "PEPE@gmail.com")
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
                            Text(text = "452554")
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
                        onClick = { })
                }
            }

        }
    }

}