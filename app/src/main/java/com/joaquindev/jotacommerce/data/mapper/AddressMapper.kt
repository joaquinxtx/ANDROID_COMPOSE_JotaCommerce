package com.joaquindev.jotacommerce.data.mapper

import com.joaquindev.jotacommerce.data.dataSource.local.entity.AddressEntity
import com.joaquindev.jotacommerce.domain.model.Address

fun AddressEntity.toAddress(): Address {

    return Address(
        id = id,
        address= address,
        neighborhood= neighborhood,
        idUser = idUser
    )
}
fun Address.toEntity(): AddressEntity {

    return AddressEntity(
        id = id ?: "",
        address= address,
        neighborhood= neighborhood,
        idUser = idUser
    )
}