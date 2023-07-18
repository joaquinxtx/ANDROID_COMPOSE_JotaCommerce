package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Product
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ProductRepository {
    fun findAll():Flow<Resource<List<Product>>>
    fun findAllByCategory(idCategory:String):Flow<Resource<List<Product>>>
    suspend fun create(product: Product, files:List<File>): Resource<Product>
    suspend fun update(id:String,product: Product, files:List<File>?): Resource<Product>
    suspend fun delete(id:String): Resource<Unit>
}