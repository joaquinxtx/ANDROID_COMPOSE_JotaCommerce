package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.repository.dataSource.AuthRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.repository.AuthRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest


class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> =
        ResponseToRequest.send(authRemoteDataSource.login(email, password))

    override suspend fun register(user: User): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.register(user)
        )
}
