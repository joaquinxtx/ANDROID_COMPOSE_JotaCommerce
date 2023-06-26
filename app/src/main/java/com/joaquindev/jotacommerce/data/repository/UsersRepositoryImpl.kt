package com.joaquindev.jotacommerce.data.repository


import com.joaquindev.jotacommerce.data.repository.dataSource.UsersRemoteDataSource

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.repository.UserRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,

    ) : UserRepository {
    override suspend fun update(id:String ,user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id ,user)
    )
}

