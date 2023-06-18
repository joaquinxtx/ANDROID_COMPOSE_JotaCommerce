package com.joaquindev.jotacommerce.data.repository.dataSourceImpl

import com.joaquindev.jotacommerce.data.datastore.AuthDataStore
import com.joaquindev.jotacommerce.data.repository.dataSource.AuthLocalDataSource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) : AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}