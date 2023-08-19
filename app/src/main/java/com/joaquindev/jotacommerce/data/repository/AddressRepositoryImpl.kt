package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.dataSource.local.AddressLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.AddressRemoteDataSource
import com.joaquindev.jotacommerce.data.mapper.toAddress
import com.joaquindev.jotacommerce.data.mapper.toEntity
import com.joaquindev.jotacommerce.data.mapper.toProduct
import com.joaquindev.jotacommerce.data.mapper.toProductsEntity
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.domain.repository.AddressRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import com.joaquindev.jotacommerce.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddressRepositoryImpl(
    private val remoteDataSource: AddressRemoteDataSource,
    private val localDataSource: AddressLocalDataSource
) : AddressRepository {
    override suspend fun create(address: Address): Resource<Address> {
        ResponseToRequest.send(remoteDataSource.create(address)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.insert(this.data.toEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override fun findByUser(idUser: String): Flow<Resource<List<Address>>> = flow {
        localDataSource.findByUser(idUser).collect() {
            it.run {
                val addressLocalMap = this.map { addressEntity -> addressEntity.toAddress() }

                try {
                    ResponseToRequest.send(remoteDataSource.findByUser(idUser))
                        .run {
                            when (this) {
                                is Resource.Success -> {
                                    val addressRemote = this.data
                                    if (!isListEqual(addressRemote, addressLocalMap)) {
                                        localDataSource.insertAll(addressRemote.map { address -> address.toEntity() })
                                    }
                                    emit(Resource.Success(addressRemote))
                                }
                                else -> {
                                    emit(Resource.Success(addressLocalMap))
                                }
                            }
                        }
                } catch (e: Exception) {
                    emit(Resource.Success(addressLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}