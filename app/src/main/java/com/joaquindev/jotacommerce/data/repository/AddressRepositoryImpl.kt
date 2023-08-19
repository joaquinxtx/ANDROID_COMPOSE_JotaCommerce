package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.dataSource.remote.AddressRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.domain.repository.AddressRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressRepositoryImpl (private val remoteDataSource: AddressRemoteDataSource) : AddressRepository {
    override suspend fun create(address: Address): Resource<Address> = ResponseToRequest.send(
        remoteDataSource.create(address)
    )

    override fun findByUser(idUser: String): Flow<Resource<List<Address>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByUser(idUser)))
    }
}