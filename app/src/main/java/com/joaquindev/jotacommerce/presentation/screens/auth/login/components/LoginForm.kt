package com.joaquindev.jotacommerce.presentation.screens.auth.login.components


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.AuthScreen
import com.joaquindev.jotacommerce.presentation.navigation.screen.RolesScreen
import com.joaquindev.jotacommerce.presentation.screens.auth.login.LoginViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe10
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe5
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe6

@Composable
fun LoginForm(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    val state = vm.stateForm
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {

            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }



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
                value = state.email,
                onValueChange = {
                    vm.onEmailInput(it)
                },
                label = "Correo electronico",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.password,
                onValueChange = {
                    vm.onPasswordInput(it)
                },
                label = "Contraseña",
                icon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                hideText = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            DefaultButton(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), text = "LOGIN", onClick = {
                vm.login()
            })
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "No tienes cuenta?", color = Cafe10)
                Text(
                    text = " Registrate",
                    color = Cafe5,
                    modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) })
            }
        }
    }
    when (val response = vm.loginResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                if (response.data.user?.roles!!.size > 1){
                    navController.navigate(route = Graph.ROLES){
                        popUpTo(Graph.AUTH){inclusive=true}
                    }
                }else{
                    navController.navigate(route = Graph.CLIENT){
                        popUpTo(Graph.AUTH){inclusive=true}
                    }

                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT)
                .show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error Desconocido", Toast.LENGTH_SHORT).show()

            }
        }
    }
}