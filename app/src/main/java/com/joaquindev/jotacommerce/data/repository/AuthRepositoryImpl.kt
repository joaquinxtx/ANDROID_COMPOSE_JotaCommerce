package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.dataSource.local.AuthLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.AuthRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.repository.AuthRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow


class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> =
        ResponseToRequest.send(authRemoteDataSource.login(email, password))

    override suspend fun register(user: User): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.register(user)
        )

    override suspend fun logout() = authLocalDataSource.logout()

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()
}

