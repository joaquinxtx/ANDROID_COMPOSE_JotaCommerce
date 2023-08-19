package com.joaquindev.jotacommerce.presentation.screens.address.create.mapper

import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.presentation.screens.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress():Address{
    return Address(
        address= address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}