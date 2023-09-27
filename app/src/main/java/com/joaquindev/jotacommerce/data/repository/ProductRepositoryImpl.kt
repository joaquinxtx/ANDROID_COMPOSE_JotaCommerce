package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.dataSource.local.ProductsLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.ProductRemoteDataSource
import com.joaquindev.jotacommerce.data.mapper.toProduct
import com.joaquindev.jotacommerce.data.mapper.toProductsEntity
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.repository.ProductRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import com.joaquindev.jotacommerce.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class ProductRepositoryImpl(
    private val remoteDataSource: ProductRemoteDataSource,
    private val localDataSource: ProductsLocalDataSource
) :
    ProductRepository {
    override fun findAll(): Flow<Resource<List<Product>>> = flow {
        localDataSource.findAll().collect{
            it.run {
                val productsLocalMap = this.map { productsEntity -> productsEntity.toProduct() }

                try {
                    ResponseToRequest.send(remoteDataSource.findAll())
                        .run {

                            when (this) {
                                is Resource.Success -> {
                                    val productsRemote = this.data
                                    if (!isListEqual(productsRemote, productsLocalMap)) {
                                        localDataSource.insertAll(productsRemote.map { product -> product.toProductsEntity() })
                                    }
                                    emit(Resource.Success(productsRemote))
                                }
                                else -> {
                                    emit(Resource.Success(productsLocalMap))
                                }
                            }
                        }
                } catch (e: Exception) {
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)


    override fun findAllByCategory(idCategory: String): Flow<Resource<List<Product>>> = flow {
        localDataSource.findByCategory(idCategory).collect {
            it.run {
                val productsLocalMap = this.map { productsEntity -> productsEntity.toProduct() }

                try {
                    ResponseToRequest.send(remoteDataSource.findAllByCategory(idCategory = idCategory))
                        .run {

                            when (this) {
                                is Resource.Success -> {
                                    val productsRemote = this.data
                                    if (!isListEqual(productsRemote, productsLocalMap)) {
                                        localDataSource.insertAll(productsRemote.map { product -> product.toProductsEntity() })

                                    }
                                    emit(Resource.Success(productsRemote))

                                }
                                else -> {
                                    emit(Resource.Success(productsLocalMap))
                                }
                            }
                        }
                } catch (e: Exception) {
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun create(product: Product, files: List<File>): Resource<Product> {
        ResponseToRequest.send(remoteDataSource.create(product, files)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.insert(this.data.toProductsEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Unknown error")
                }
            }
        }

    }

    override suspend fun update(id: String, product: Product): Resource<Product> {
        ResponseToRequest.send(remoteDataSource.update(id, product)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        price = this.data.price
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Unknown error")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, product, files)).run {

            return when (this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        price = this.data.price
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Unknown error")
                }
            }
        }

    }

    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Unknown error")
                }
            }
        }
    }
}