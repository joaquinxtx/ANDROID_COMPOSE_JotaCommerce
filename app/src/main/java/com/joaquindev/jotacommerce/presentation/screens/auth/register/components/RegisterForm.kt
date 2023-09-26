package com.joaquindev.jotacommerce.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
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
import com.joaquindev.jotacommerce.presentation.screens.auth.register.RegisterViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@Composable
fun RegisterForm( vm: RegisterViewModel = hiltViewModel() , navController: NavHostController) {

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
            .fillMaxWidth(),
        shape = RoundedCornerShape(
            topEnd = 35.dp,
            topStart = 35.dp
        ), colors = CardDefaults.cardColors(Cafe_white.copy(alpha = 0.7f))
    ) {
        Column(modifier = Modifier.padding(top = 20.dp, start = 30.dp, end = 30.dp)) {

            Text(
                text = stringResource(id = R.string.register),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Cafe_blue,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.name,
                onValueChange = { vm.onNameInput(it) },
                label = stringResource(id = R.string.name),
                icon = Icons.Default.Person,
                keyboardType = KeyboardType.Text
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.lastname,
                onValueChange = { vm.onLastNameInput(it) },
                label = stringResource(id = R.string.last_name),
                icon = Icons.Outlined.Person,
                keyboardType = KeyboardType.Text
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.email,
                onValueChange = { vm.onEmailInput(it) },
                label = stringResource(id = R.string.email),
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.phone,
                onValueChange = { vm.onPhoneInput(it) },
                label = stringResource(id = R.string.phone),
                icon = Icons.Default.Phone,
                keyboardType = KeyboardType.Number
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.password,
                onValueChange = { vm.onPasswordInput(it) },
                label = stringResource(id = R.string.password),
                icon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                hideText = true
            )
            DefaultTextField(
                modifier = Modifier,
                value = state.confirmPassword,
                onValueChange = { vm.onConfirmPasswordInput(it) },
                label = stringResource(id = R.string.confirm_password),
                icon = Icons.Outlined.Lock,
                keyboardType = KeyboardType.Password,
                hideText = true
            )

            Spacer(modifier = Modifier.height(10.dp))
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                text = stringResource(id = R.string.register),
                onClick = { vm.register() })
            Spacer(modifier = Modifier.height(10.dp))

        }
    }

}