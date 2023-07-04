package com.joaquindev.jotacommerce.presentation.screens.admin.category.create.mapper

import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {

    return Category(
        name=name,
        description = description,
        image = image
    )

}