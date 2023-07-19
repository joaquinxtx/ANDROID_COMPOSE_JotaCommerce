package com.joaquindev.jotacommerce.data.dataSource.remote


import com.joaquindev.jotacommerce.domain.model.Product

import retrofit2.Response
import java.io.File

interface ProductRemoteDataSource {

    suspend fun findAll(): Response<List<Product>>
    suspend fun findAllByCategory(idCategory:String): Response<List<Product>>
    suspend fun create(product: Product, files:List<File>): Response<Product>
    suspend fun update(id:String, product: Product, files:List<File>?): Response<Product>
    suspend fun delete(id:String): Response<Unit>
}