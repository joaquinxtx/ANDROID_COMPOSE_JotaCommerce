package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import kotlinx.coroutines.flow.Flow

interface ShoppingBagRepository {

    suspend fun add(product:ShoppingBagProduct)
    suspend fun delete(product:ShoppingBagProduct)
    suspend fun findAll(product:ShoppingBagProduct):Flow<List<ShoppingBagProduct>>


}