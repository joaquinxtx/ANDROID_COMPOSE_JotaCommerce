package com.joaquindev.jotacommerce.data.repository.dataSourceImpl

import com.joaquindev.jotacommerce.data.repository.dataSource.UsersRemoteDataSource
import com.joaquindev.jotacommerce.data.service.UsersService
import com.joaquindev.jotacommerce.domain.model.User
import retrofit2.Response

class UsersRemoteDataSourceImpl(private val usersService: UsersService) : UsersRemoteDataSource{
    override suspend fun update(id:String ,user: User): Response<User> = usersService.update(id , user)


}