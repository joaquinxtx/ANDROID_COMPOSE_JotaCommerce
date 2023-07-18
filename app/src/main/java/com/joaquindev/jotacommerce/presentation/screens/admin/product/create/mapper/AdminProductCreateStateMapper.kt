package com.joaquindev.jotacommerce.presentation.screens.admin.product.create.mapper

import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.AdminProductCreateState

fun AdminProductCreateState.toProduct():Product{
    return Product(

        name = name,
        description = description,
        idCategory = idCategory,
        price = price,

    )
}