package com.joaquindev.jotacommerce.data.dataSource.local

import com.joaquindev.jotacommerce.data.dataSource.local.datastore.AuthDataStore
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) :
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override suspend fun logout()= authDataStore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}