package com.joaquindev.jotacommerce.presentation.screens.admin.product.update.mapper

import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.AdminProductCreateState
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product {
    return Product(
        id = id,
        name = name,
        description = description,
        idCategory = idCategory,
        price = price,
        imageToUpdate = imagesToUpdate.toList(),
        image2 = image2,
        image1 = image1

    )
}