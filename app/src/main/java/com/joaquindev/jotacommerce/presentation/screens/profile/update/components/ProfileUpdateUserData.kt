package com.joaquindev.jotacommerce.presentation.screens.profile.update.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ProfileUpdateUserData(vm: ProfileUpdateViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp
        ),
        colors = CardDefaults.cardColors(Cafe_white.copy(alpha = 0.8f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {


            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "Nombre",
                icon = Icons.Default.Person
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "Apellido",
                icon = Icons.Default.Person
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "Email",
                icon = Icons.Default.Email
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "Telefono",
                icon = Icons.Default.Phone
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
        DefaultButton(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            text = "Confirmar",
            onClick = { })
    }
}
