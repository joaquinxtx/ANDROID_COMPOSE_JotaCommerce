package com.joaquindev.jotacommerce.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_black
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value:String,
    onValueChange:(value:String)->Unit,
    label:String,
    icon:ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText:Boolean = false,
    maxLine:Int = 1


){
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp),
        value = value,
        onValueChange = { onValueChange(it) },
        maxLines = maxLine,

        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = R.string.icon),
                tint = Cafe_orange
            )
        },

        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(containerColor = Cafe_black.copy(alpha = 0f)),
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None

        )
}