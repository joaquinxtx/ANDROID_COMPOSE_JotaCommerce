package com.joaquindev.jotacommerce.presentation.screens.admin.category.update.mapper

import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.AdminCategoryUpdateState

fun AdminCategoryUpdateState.toCategory(): Category {

    return Category(
        name=name,
        description = description,
        image = image
    )

}