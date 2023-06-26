package com.joaquindev.jotacommerce.presentation.screens.auth.register.mapper

import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser():User{
    return User(
        name=name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password,

    )
}