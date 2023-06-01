package com.joaquindev.jotacommerce.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.navigation.screen.AuthScreen
import com.joaquindev.jotacommerce.presentation.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(navController : NavHostController,paddingValues: PaddingValues ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Image(
            painter = painterResource(id = R.drawable.coffe2),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(
                    0.5f,
                    0.5f,
                    0.5f,
                    1f
                )

            })
        )

    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 70.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.iconlogin),
            contentDescription = "",
            modifier = Modifier
                .height(85.dp)
                .width(85.dp)
        )
        Text(
            text = "Coffee +",
            color = Color(color = 0xFFEEDACD),
            fontSize = 29.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Card(
            modifier = Modifier
                .height(320.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ), colors = CardDefaults.cardColors(Cafe6)
        ) {
            Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)) {
                Text(
                    text = "INGRESAR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Cafe5,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                DefaultTextField(
                    modifier = Modifier,
                    value = "",
                    onValueChange = {},
                    label = "Correo electronico",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email
                )
                DefaultTextField(
                    modifier = Modifier,
                    value = "",
                    onValueChange = {},
                    label = "Contraseña",
                    icon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password
                )
                Spacer(modifier = Modifier.height(10.dp) )
                DefaultButton(modifier = Modifier.fillMaxWidth().height(50.dp), text = "LOGIN" , onClick = { })
                Spacer(modifier = Modifier.height(10.dp) )
                Row(
                    Modifier
                        .fillMaxWidth()
                        , horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "No tienes cuenta?", color = Cafe10)
                    Text(text = " Registrate", color = Cafe5 , modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) })
                }
            }
        }


    }


}