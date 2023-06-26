package com.joaquindev.jotacommerce.presentation.screens.profile.update.mapper

import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser():User{
    return User(
        name=name ,
        lastname = lastname,
        phone = phone,
        image=image
    )
}