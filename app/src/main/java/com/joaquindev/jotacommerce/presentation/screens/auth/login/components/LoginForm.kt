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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.navigation.screen.auth.AuthScreen
import com.joaquindev.jotacommerce.presentation.screens.auth.login.LoginViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.*

@Composable
fun LoginForm(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    val state = vm.state
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
        ), colors = CardDefaults.cardColors(Cafe_white.copy(alpha = 0.7f))
    ) {
        Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)) {
            Text(
                text = stringResource(id = R.string.get_into),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Cafe_blue,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.email,
                onValueChange = {
                    vm.onEmailInput(it)
                },
                label = stringResource(id = R.string.email),
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.password,
                onValueChange = {
                    vm.onPasswordInput(it)
                },
                label =stringResource(id = R.string.password),
                icon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                hideText = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            DefaultButton(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), text = stringResource(id = R.string.login), onClick = {
                vm.login()
            })
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.you_do_not_have_an_account), color = Cafe_blue)
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Cafe_orange,
                    modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) })
            }
        }
    }

}