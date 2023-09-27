package com.joaquindev.jotacommerce.presentation.screens.profile.update.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateState
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun ProfileUpdateUserData(vm: ProfileUpdateViewModel, state : ProfileUpdateState) {

    Card(
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp , end = 10.dp), shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp
        ),
        colors = CardDefaults.cardColors(Cafe_white)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = stringResource(id = R.string.update_profile),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Cafe_blue,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.name,
                onValueChange = {vm.onNameInput(it)},
                label = stringResource(id = R.string.name),
                icon = Icons.Default.Person
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value =  state.lastname,
                onValueChange = {vm.onLastNameInput(it)},
                label = stringResource(id = R.string.last_name),
                icon = Icons.Default.Person
            )

            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value =  state.phone,
                onValueChange = {vm.onPhoneInput(it)},
                label = stringResource(id = R.string.phone),
                icon = Icons.Default.Phone
            )

            Spacer(modifier = Modifier.height(10.dp))
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                text = stringResource(id = R.string.confirm),
                onClick = { vm.onUpdate() })
        }

    }


}
