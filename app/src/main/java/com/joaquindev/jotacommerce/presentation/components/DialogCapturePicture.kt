package com.joaquindev.jotacommerce.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit
) {
    if (state.value){
        Dialog(onDismissRequest = { state.value = false}) {
            Card(
                colors = CardDefaults.cardColors(Cafe_white.copy(alpha = 0.8f))
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.camara),
                            contentDescription = stringResource(id = R.string.image),
                            Modifier
                                .size(39.dp),
                            )

                    }
                    Divider(
                        thickness = 1.dp,
                        color = Cafe_blue,
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(560.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.picture),
                        modifier = Modifier
                            .align(
                                Alignment.CenterHorizontally
                            ),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Divider(
                        thickness = 1.dp,
                        color = Cafe_blue,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .width(560.dp)
                    )
                    Row(modifier = Modifier.padding(bottom = 16.dp).align(Alignment.End)  ) {
                        TextButton(onClick = {
                            state.value=false
                            takePhoto()
                        }) {
                            Text(text = stringResource(id = R.string.camera))
                        }
                        TextButton(onClick = {
                            state.value=false
                            pickImage()
                        }) {
                            Text(text = stringResource(id = R.string.gallery))
                        }

                    }
                }
            }
        }
    }
}