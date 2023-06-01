package com.joaquindev.jotacommerce.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe8
import com.joaquindev.jotacommerce.presentation.ui.theme.CafeTrasparent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value:String,
    onValueChange:(value:String)->Unit,
    label:String,
    icon:ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text


){
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp),
        value = value,
        onValueChange = { onValueChange(it) },

        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "",
                tint = Cafe8
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(containerColor = CafeTrasparent)

        )
}