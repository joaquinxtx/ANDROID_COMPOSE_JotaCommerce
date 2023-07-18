package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.dataSource.remote.ProductRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.repository.ProductRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import java.io.File

class ProductRepositoryImpl(private val productRemoteDataSource: ProductRemoteDataSource) :
    ProductRepository {
    override fun findAll(): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override fun findAllByCategory(idCategory: String): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override suspend fun create(product: Product, files: List<File>): Resource<Product> =
        ResponseToRequest.send(
            productRemoteDataSource.create(product, files)
        )

    override suspend fun update(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}